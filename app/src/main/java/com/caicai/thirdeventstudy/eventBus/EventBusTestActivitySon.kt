package com.caicai.thirdeventstudy.eventBus

import android.widget.Toast
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class EventBusTestActivitySon: EventBusTestActivity() {
    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true, priority = 11)
    override fun handleEventBusMessage(msg: MessageEvent) {
        Toast.makeText(this, "Activity 收到MessageEvent了， ${msg.message}", Toast.LENGTH_SHORT)
            .show()
    }
}