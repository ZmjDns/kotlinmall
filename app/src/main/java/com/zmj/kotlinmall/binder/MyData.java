package com.zmj.kotlinmall.binder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/16
 * Description :
 * 1.用于Binder通信传递的数据
 * 2.特别注意：此类的包名（package）必须要与对应的MyData.aidl文件的包名一样，否则报错
 */
public class MyData implements Parcelable {

    private int data1;
    private String data2;

    public MyData() {
    }


    protected MyData(Parcel in) {
        readFromParcel(in);
    }

    public static final Creator<MyData> CREATOR = new Creator<MyData>() {
        @Override
        public MyData createFromParcel(Parcel in) {
            return new MyData(in);
        }

        @Override
        public MyData[] newArray(int size) {
            return new MyData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(data1);
        dest.writeString(data2);
    }

    public void readFromParcel(Parcel in){
        data1 = in.readInt();
        data2 = in.readString();
    }

    public int getData1() {
        return data1;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    @Override
    public String toString() {
        return "data1 = "+ data1 + ", data2="+ data2;
    }
}
