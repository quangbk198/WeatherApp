package com.example.weatherapp.core.base.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.viewbinding.ViewBinding
import com.example.weatherapp.R
import com.example.weatherapp.core.base.viewmodel.BaseViewModel
import com.example.weatherapp.utils.view.LoadingDialog
import com.example.weatherapp.utils.view.NoticeDialog

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel>(
    val bindingFactory: (LayoutInflater) -> VB
) : AppCompatActivity(), IBehavior {

    lateinit var binding: VB

    abstract val viewModel: VM

    private val loadingDialog by lazy {
        LoadingDialog(this)
    }

    private val noticeDialog by lazy {
        NoticeDialog(this)
    }

    protected open val isLightStatusBar = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)

        setStatusBarColor()
        enableEdgeToEdge()

        onInitView()
        onInitListener()
        onObserveData()
    }

    private fun enableEdgeToEdge() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    private fun setStatusBarColor() {
        window.statusBarColor = Color.TRANSPARENT
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = isLightStatusBar
        }
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

    override fun onError(errMess: String?) {
        noticeDialog.newBuild().setContent(
            errMess ?: getString(R.string.common_error)
        ).show()
    }
}