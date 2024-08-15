package com.caicai.thirdeventstudy

import android.app.Application
import com.example.myapp.MyEventBusIndex
import org.greenrobot.eventbus.EventBus

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        EventBus.builder().addIndex(MyEventBusIndex()).installDefaultEventBus()
    }
}