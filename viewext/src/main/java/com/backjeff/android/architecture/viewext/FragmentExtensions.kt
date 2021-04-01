package com.backjeff.android.architecture.viewext

import androidx.activity.OnBackPressedCallback
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

fun Fragment.getColor(@ColorRes colorId: Int) = ContextCompat.getColor(requireContext(), colorId)
fun Fragment.getDrawable(@ColorRes drawableId: Int) = ContextCompat.getColor(requireContext(), drawableId)

fun Fragment.addOnBackPressedCallback(
    owner: LifecycleOwner,
    onBackPressed: () -> Unit
) {
    (requireActivity() as? AppCompatActivity)?.onBackPressedDispatcher?.addCallback(
        owner,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
    )
}
