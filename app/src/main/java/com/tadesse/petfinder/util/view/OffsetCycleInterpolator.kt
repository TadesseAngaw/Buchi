package com.tadesse.petfinder.util.view

import android.content.Context
import android.util.AttributeSet
import android.view.animation.CycleInterpolator

class OffsetCycleInterpolator : CycleInterpolator {
    private var offset: Float = 0.0f

    constructor(offset: Float) : super(1f) {
        this.offset = offset
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun getInterpolation(input: Float): Float {
        return Math.sin(2.0 * Math.PI * input.toDouble() + offset).toFloat() + 1f
    }
}
