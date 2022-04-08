package com.tadesse.petfinder.util.ktx

import android.view.MenuInflater
import android.view.View
import androidx.annotation.MenuRes
import androidx.appcompat.widget.PopupMenu
import com.inmp.yetale.base.util.view.ViewUtils.goneView
import com.inmp.yetale.base.util.view.ViewUtils.goneViews
import com.inmp.yetale.base.util.view.ViewUtils.hideView
import com.inmp.yetale.base.util.view.ViewUtils.hideViews
import com.inmp.yetale.base.util.view.ViewUtils.showView
import com.inmp.yetale.base.util.view.ViewUtils.showViews

fun View.showPopup(@MenuRes menuRes: Int, listener: PopupMenu.OnMenuItemClickListener) {
    val popup = PopupMenu(this.context, this)
    val inflater: MenuInflater = popup.menuInflater
    inflater.inflate(menuRes, popup.menu)
    popup.show()

    popup.setOnMenuItemClickListener(listener)
}

fun View.gone(isAnimated: Boolean = true, isSlow: Boolean = true){
    goneView(this)
}

fun Collection<View>.gone(isAnimated: Boolean = true, isSlow: Boolean = true){
    goneViews(this)
}


fun View.hide(isAnimated: Boolean = true, isSlow: Boolean = true){
    hideView(this)
}

fun Collection<View>.hide(isAnimated: Boolean = true, isSlow: Boolean = true){
    hideViews(this)
}


fun View.show(isAnimated: Boolean = true, isSlow: Boolean = true){
    showView(this)
}

fun Collection<View>.show(isAnimated: Boolean = true, isSlow: Boolean = true){
    showViews(this)
}


