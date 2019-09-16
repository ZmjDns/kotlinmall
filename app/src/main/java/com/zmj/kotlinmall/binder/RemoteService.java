package com.zmj.kotlinmall.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import com.zmj.kotlinmall.IRemoteService;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/16
 * Description :
 */
public class RemoteService extends Service {

    private static final String TAG = "RemoteService";

    MyData mMydata;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: [RemoteService]");
        initMyData();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: [RemoteService] onBind()");
        return mBinder ;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
        @Override
        public int getPid() throws RemoteException {
            Log.i(TAG, "getPid: [RemoteService] getPid():" + android.os.Process.myPid());
            return Process.myPid();
        }

        @Override
        public MyData getData() throws RemoteException {
            Log.i(TAG, "getData: [RemoteService] getMyData():" + mMydata.toString());
            return mMydata;
        }

        /**
         *此处用于权限拦截
         * @param code
         * @param data
         * @param reply
         * @param flags
         * @return
         * @throws RemoteException
         */
        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Log.i(TAG, "onTransact: code=" + code + "\ndata=" + data.toString() + "\nreplay=" + reply.toString() + "\nflags=" + flags);
            return super.onTransact(code, data, reply, flags);
        }
    };



    private void initMyData() {
        mMydata = new MyData();
        mMydata.setData1(9999);
        mMydata.setData2("hello binder");
    }
}
