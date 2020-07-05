package com.leandroid.gameofthrones.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.leandroid.gameofthrones.R

class CommomCardView
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val nameView by lazy<TextView> { findViewById(R.id.name) }

    init {
        inflate(context, R.layout.widget_commom_card, this)
    }

    fun setName(name: String?) {
        nameView.text = name
    }

}