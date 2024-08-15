package com.caicai.thirdeventstudy.eventBus

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.caicai.thirdeventstudy.R
import org.greenrobot.eventbus.EventBus

class EventBusEmptyActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        supportActionBar?.hide()
        findViewById<View>(R.id.post_sticky).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.post_sticky -> {
                EventBus.getDefault().postSticky(MessageEvent("菜菜发送粘黏的消息"))
                finish()
            }
        }
    }
}
