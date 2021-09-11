package com.project.publicproject

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import java.lang.reflect.Array.get
import javax.inject.Inject

abstract class BaseActivity<V : ViewModel, D : ViewDataBinding> : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: V
    protected lateinit var dataBinding: D

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract fun getViewModel(): Class<V>

    protected abstract fun initLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, layoutRes)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(getViewModel())
    }
}