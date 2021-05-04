package com.example.calculatorkotlin

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout

class CalculatorInputView(context: Context, attributeSet: AttributeSet?) :
    RelativeLayout(context, attributeSet) {

    init {
        // Inflate Layout
        LayoutInflater.from(context).inflate(R.layout.view_calculator_input, this, true);

        // Read attribute set
        attributeSet?.run {
            val typedArray: = context
        }
    }
}