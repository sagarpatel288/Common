package com.example.android.common.baselisteners

import android.os.SystemClock
import android.view.View

class OnSingleClickListener(private val block: () -> Unit) : View.OnClickListener {

    private var lastClickTime = 0L

    override fun onClick(view: View) {
        // comment by srdpatel: 2/5/2021 Do not allow next click again until 3000ms
        if (SystemClock.elapsedRealtime() - lastClickTime < 3000) {
            return
        }
        lastClickTime = SystemClock.elapsedRealtime()

        block()
    }
}

fun View.setOnSingleClickListener(block: () -> Unit) {
    setOnClickListener(OnSingleClickListener(block))
}