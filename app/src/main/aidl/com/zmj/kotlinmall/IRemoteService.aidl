package com.zmj.kotlinmall;

import com.zmj.kotlinmall.binder.MyData;

interface IRemoteService{

    int getPid();

    MyData getData();
}
