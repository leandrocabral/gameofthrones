package com.leandroid.gameofthrones.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.getStringOrThrow
import androidx.core.content.withStyledAttributes
import com.leandroid.gameofthrones.R

class CommomCardView
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val nameView by lazy<TextView> { findViewById(R.id.name) }

    init {
        inflate(context, R.layout.widget_commom_card, this)
        applyAttributes(attrs, defStyleAttr)
    }

    private fun applyAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        context.withStyledAttributes(attrs, R.styleable.CommomCard, defStyleAttr) {
            nameView.text = getStringOrThrow(R.styleable.CommomCard_commom_card_description)
        }
    }

}