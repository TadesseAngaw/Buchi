package com.tadesse.petfinder.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SearchPetsItemDecoration() : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        when ((view.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition) {
            0 -> outRect.set(
                Screen.dp(16),
                Screen.dp(16),
                Screen.dp(16),
                Screen.dp(12)
            )
            parent.adapter!!.itemCount - 1 -> outRect.set(
                Screen.dp(16),
                Screen.dp(12),
                Screen.dp(16),
                Screen.dp(16)
            )
            else -> outRect.set(
                Screen.dp(16),
                Screen.dp(12),
                Screen.dp(16),
                Screen.dp(12)
            )
        }
    }
}