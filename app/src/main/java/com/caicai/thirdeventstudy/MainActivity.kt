package com.caicai.thirdeventstudy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import com.caicai.thirdeventstudy.eventBus.EventBusTestActivity
import com.caicai.thirdeventstudy.eventBus.EventBusTestActivitySon

class MainActivity : ComponentActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_eventbus).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_eventbus -> {
                startActivity(Intent(this, EventBusTestActivitySon::class.java))
            }
        }
    }
}

