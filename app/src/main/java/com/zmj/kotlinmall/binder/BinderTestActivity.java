package com.zmj.kotlinmall.binder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.zmj.kotlinmall.IRemoteService;
import com.zmj.kotlinmall.R;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/16
 * Description :
 */
public class BinderTestActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "BinderTestActivity";

    private IRemoteService mRemoteService;
    private boolean isBind = false;

    private TextView tv_callBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_binder);

        findViewById(R.id.btn_startService).setOnClickListener(this);
        findViewById(R.id.btn_bind).setOnClickListener(this);
        findViewById(R.id.btn_unbind).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
        findViewById(R.id.btn_kill).setOnClickListener(this);

        tv_callBack = findViewById(R.id.tv_callBack);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_startService:
                startService();
                break;
            case R.id.btn_bind:
                bindRemoteService();
                break;
            case R.id.btn_unbind:
                unbindRemoteService();
                break;
            case R.id.btn_stop:
                stopService();
                break;
            case R.id.btn_kill:
                killRemoteService();
                break;
        }
    }

    /**
     * 用于监控远程连接的状态
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: 服务绑定成功");
            isBind = true;

            mRemoteService = IRemoteService.Stub.asInterface(service);
            String pidInfo =null;

            try{
                MyData myData = mRemoteService.getData();
                pidInfo = "pid=" + mRemoteService.getPid() + "data1" + myData.getData1() + "data2" + myData.getData2();
            }catch (Exception e){
                e.printStackTrace();
            }
            Log.i(TAG, "onServiceConnected: " + pidInfo);

            tv_callBack.setText(pidInfo);
            Toast.makeText(BinderTestActivity.this, "RemoteServiceConnected", Toast.LENGTH_SHORT).show();

        }

        /**
         * 在服务进程被kill的时候才会走此方法
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;
            Log.i(TAG, "服务已断开(killed)");
            tv_callBack.setText("ServiceDisconnected");

            mRemoteService = null;
            Toast.makeText(BinderTestActivity.this, "RemoteServiceDisconnected", Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * 启动服务
     */
    private void startService(){
        startService(new Intent(this,RemoteService.class));
    }

    /**
     * 绑定服务
     */
    private void bindRemoteService(){
        Intent intent = new Intent(this,RemoteService.class);
        intent.setAction(IRemoteService.class.getName());
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);

        tv_callBack.setText("binding...");
        Log.i(TAG, "bindRemoteService: 正在绑定服务.......");
    }

    /**
     * 解绑服务
     */
    private void unbindRemoteService(){
        if (isBind){
            unbindService(mConnection);
            Log.i(TAG, "服务已解绑.....");
            tv_callBack.setText("unBinded");
        }
    }

    /**
     * 停止服务
     */
    private void stopService(){
        stopService(new Intent(this,RemoteService.class));
    }

    /**
     * 结束服务进程
     */
    private void killRemoteService(){
        try {
            Log.i(TAG, "killRemoteService: 正在杀死服务.......");
            android.os.Process.killProcess(mRemoteService.getPid());
            Log.i(TAG, "killRemoteService: 远程服务已杀死");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
