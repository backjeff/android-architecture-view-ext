package com.backjeff.android.architecture.viewext.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding>(
    layout: Int
) : Fragment(layout) {

    lateinit var binding: Binding
    abstract fun setRootBinding(): Binding

    open fun addObservers(owner: LifecycleOwner) { /* ignored */ }
    open fun setupView() { /* ignored */ }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addObservers(viewLifecycleOwner)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = setRootBinding()
        return binding.root
    }
}
