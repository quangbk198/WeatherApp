package com.example.weatherapp.utils.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import com.example.weatherapp.R
import com.example.weatherapp.databinding.NoticeDialogLayoutBinding
import com.example.weatherapp.utils.hide
import com.example.weatherapp.utils.show

class NoticeDialog(
    context: Context
) : Dialog(context) {

    private lateinit var binding: NoticeDialogLayoutBinding

    private var onClickBtnLeft: () -> Unit = {}
    private var onClickBtnRight: () -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = NoticeDialogLayoutBinding.inflate(
            LayoutInflater.from(context)
        )

        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(binding.root)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.btnLeft.setOnClickListener {
            onClickBtnLeft.invoke()
            dismiss()
        }

        binding.btnRight.setOnClickListener {
            onClickBtnRight.invoke()
            dismiss()
        }
    }

    fun newBuild(): NoticeDialog {
        binding.apply {
            tvTitle.text = context.getString(R.string.notification)
            tvContent.text = ""
            btnLeft.hide()
            btnLeft.text = context.getString(R.string.cancel)
            btnRight.show()
            btnRight.text = context.getString(R.string.confirm)
        }

        return this
    }

    fun setTitle(title: String?): NoticeDialog {
        binding.tvTitle.text = if (title.isNullOrEmpty()) {
            context.getString(R.string.notification)
        } else {
            title
        }

        return this
    }

    fun setContent(des: String?): NoticeDialog {
        binding.tvContent.text = des ?: ""

        return this
    }

    fun setButtonLeft(title: String?): NoticeDialog {
        binding.btnLeft.text = if (title.isNullOrEmpty()) {
            context.getString(R.string.cancel)
        } else {
            title
        }

        return this
    }

    fun setButtonLeft(title: String?, onClick: () -> Unit): NoticeDialog {
        binding.btnLeft.text = if (title.isNullOrEmpty()) {
            context.getString(R.string.cancel)
        } else {
            title
        }

        onClickBtnLeft = onClick

        return this
    }

    fun setButtonRight(title: String?): NoticeDialog {
        binding.btnRight.text = if (title.isNullOrEmpty()) {
            context.getString(R.string.confirm)
        } else {
            title
        }

        return this
    }

    fun setButtonRight(title: String?, onClick: () -> Unit): NoticeDialog {
        binding.btnRight.text = if (title.isNullOrEmpty()) {
            context.getString(R.string.confirm)
        } else {
            title
        }

        onClickBtnRight = onClick

        return this
    }

}