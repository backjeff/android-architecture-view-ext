package com.backjeff.android.architecture.viewext

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group

fun Group.hideWithFade(duration: Int = 200, startDelay: Int = 0, doAfter: () -> Unit = {}) {
    referencedIds.forEach {
        (context as? AppCompatActivity)?.findViewById<View>(it)?.hideWithFade(duration, startDelay, doAfter)
    }
}

fun Group.showWithFade(duration: Int = 200, startDelay: Int = 0, doAfter: () -> Unit = {}) {
    referencedIds.forEach {
        (context as? AppCompatActivity)?.findViewById<View>(it)?.showWithFade(duration, startDelay, doAfter)
    }
}

fun View.hideWithFade(duration: Int = 200, startDelay: Int = 0, doAfter: () -> Unit = {}) {
    setVisible()
    alpha = 1f
    animate().apply {
        alpha(0f)
        this.startDelay = startDelay.toLong()
        this.duration = duration.toLong()
        withEndAction {
            setInvisible()
            doAfter()
        }
        start()
    }
}

fun View.showWithFade(duration: Int = 200, startDelay: Int = 0, doAfter: () -> Unit = {}) {
    alpha = 0f
    setVisible()
    animate().apply {
        alpha(1f)
        this.startDelay = startDelay.toLong()
        this.duration = duration.toLong()
        withEndAction {
            doAfter()
        }
        start()
    }
}
