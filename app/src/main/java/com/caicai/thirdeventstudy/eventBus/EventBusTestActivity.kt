package com.caicai.thirdeventstudy.eventBus

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

import com.caicai.thirdeventstudy.R
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class EventBusTestActivity : Activity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus_test)
        findViewById<Button>(R.id.btn_eventbus_emit).setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED, sticky = true)
    fun handleEventBusMessage(msg: MessageEvent) {
        Toast.makeText(this, "收到MessageEvent了， ${msg.message}", Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_eventbus_emit -> EventBus.getDefault().post(MessageEvent("我是菜菜"))
        }
    }
}