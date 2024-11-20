package com.example.weatherapp.core.base.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.weatherapp.core.base.viewmodel.BaseViewModel
import com.example.weatherapp.utils.view.LoadingDialog

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel>(
    val bindingFactory: (LayoutInflater) -> VB
) : AppCompatActivity(), IBehavior {

    lateinit var binding: VB

    abstract val viewModel: VM

    private val loadingDialog by lazy {
        LoadingDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)

        onInitView()
        onInitListener()
        onObserveData()
    }

    override fun onObserveData() {
        viewModel.apply {

            loadingState.observe(this@BaseActivity) {
                onLoading(it)
            }

            errorState.observe(this@BaseActivity) {
                onError(it)
            }
        }
    }

    override fun onLoading(isLoading: Boolean) {
        if (isLoading) {
            loadingDialog.show()
        } else {
            loadingDialog.dismiss()
        }
    }

    override fun onError(errMess: String) {

    }
}