package com.caicai.thirdeventstudy.eventBus

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class EventBusTestActivitySon2: AppCompatActivity() {
    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true, priority = 11)
    fun handleEventBusMessage(msg: MessageEvent) {
        Toast.makeText(this, "EventBusTestActivitySon2 Activity 收到MessageEvent了， ${msg.message}", Toast.LENGTH_SHORT)
            .show()
        EventBus.getDefault().removeStickyEvent(msg)
    }
}