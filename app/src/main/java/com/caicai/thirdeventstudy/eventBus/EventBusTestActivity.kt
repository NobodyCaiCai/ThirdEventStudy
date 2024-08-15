package com.caicai.thirdeventstudy.eventBus

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.caicai.thirdeventstudy.R
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class EventBusTestActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus_test)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {
        supportActionBar?.hide()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.containerFragment, EventBusFragment())
                commit()
            }
        }

        findViewById<Button>(R.id.btn_eventbus_emit).setOnClickListener(this)
        findViewById<Button>(R.id.btn_open_empty).setOnClickListener(this)
    }

    override fun onStart() {
        EventBus.getDefault().register(this)
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED, sticky = true)
    fun handleEventBusMessage(msg: MessageEvent) {
        Toast.makeText(this, "Activity 收到MessageEvent了， ${msg.message}", Toast.LENGTH_LONG).show()
        EventBus.getDefault().removeStickyEvent(msg)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_eventbus_emit -> EventBus.getDefault().post(MessageEvent("我是菜菜"))


            R.id.btn_open_empty -> {
                startActivity(Intent(this, EventBusEmptyActivity::class.java))
            }
        }
    }
}