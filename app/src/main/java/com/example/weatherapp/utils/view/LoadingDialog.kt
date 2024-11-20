package com.example.weatherapp.utils.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import com.example.weatherapp.databinding.LoadingDialogLayoutBinding

class LoadingDialog(
    context: Context
) : Dialog(context) {

    private lateinit var binding: LoadingDialogLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoadingDialogLayoutBinding.inflate(
            LayoutInflater.from(context)
        )

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)

        setContentView(binding.root)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


}