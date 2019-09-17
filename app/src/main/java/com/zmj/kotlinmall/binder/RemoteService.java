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

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: Called by the system every time a client explicitly starts the service by calling android.content.Context.startService, providing the arguments it supplied and a unique integer token representing the start request.");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: [RemoteService] onBind()");
        return mBinder ;
        //return new MyBinder();
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

    /**
     *实现IRemoteService.aidl中定义的方法
     *
     * mBinder与MyBinder的实例本质是一样的，
     * MyBinder对IRemoteService.Stub的功能进行扩展，用于调用Service中的方法
     */
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
            Log.i(TAG, "onTransact: code=" + code + "data=" + data.toString() + "replay=" + reply.toString() + "flags=" + flags);
            return super.onTransact(code, data, reply, flags);
        }
    };

    /**
     * 加载数据
     */
    private void initMyData() {
        mMydata = new MyData();
        mMydata.setData1(9999);
        mMydata.setData2("hello binder");
    }

    private void method1(){
        Log.i(TAG, "method1: I am method 1");
    }

    private void method2(){
        Log.i(TAG, "method1: I am method 2");
    }

    /**
     * 通过此Binder来调用service中的方法
     * MyBinder
     */
    class MyBinder extends IRemoteService.Stub{
        public void callMethod1(){
            method1();
        }

        public String callMethod2(){
            method2();
            return "Called method2";
        }

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
            Log.i(TAG, "onTransact: code=" + code + "data=" + data.toString() + "replay=" + reply.toString() + "flags=" + flags);
            return super.onTransact(code, data, reply, flags);
        }
    }
}
