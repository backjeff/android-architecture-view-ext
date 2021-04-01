package com.backjeff.android.architecture.viewext

import android.animation.ObjectAnimator
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun View.getColor(@ColorRes colorId: Int) = ContextCompat.getColor(this.context, colorId)
fun View.getDrawable(@ColorRes drawableId: Int) = ContextCompat.getDrawable(this.context, drawableId)

fun View.setGone() { visibility = View.GONE }

fun View.setInvisible() { visibility = View.INVISIBLE }

fun View.setVisible() { visibility = View.VISIBLE }

fun ProgressBar.animatedProgressTo(fromValue: Number, toValue: Number) {
    progress = fromValue.toInt()
    animatedProgressTo(toValue)
}

fun ProgressBar.animatedProgressTo(toValue: Number) {
    ObjectAnimator.ofInt(this, "progress", toValue.toInt())
        .setDuration(300)
        .start()
}

fun withViews(vararg views: View, action: (View) -> Any) {
    views.forEach {
        action(it)
    }
}
