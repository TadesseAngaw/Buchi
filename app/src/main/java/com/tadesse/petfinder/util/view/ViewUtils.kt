package com.inmp.yetale.base.util.view

import android.graphics.Rect
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import androidx.annotation.LayoutRes
import com.tadesse.petfinder.util.Screen
import com.tadesse.petfinder.util.view.MaterialInterpolator
import com.tadesse.petfinder.util.view.OffsetCycleInterpolator


object ViewUtils {

    @JvmOverloads
    fun inflate(@LayoutRes id: Int, viewGroup: ViewGroup, attach: Boolean = false): View {
        return LayoutInflater
            .from(viewGroup.context)
            .inflate(id, viewGroup, attach)
    }

    @JvmOverloads
    fun goneView(view: View?, isAnimated: Boolean = true, isSlow: Boolean = true) {
        if (view == null) {
            return
        }
        if (isAnimated) {
            if (view.visibility != View.GONE) {
                val alphaAnimation = AlphaAnimation(1f, 0f)
                alphaAnimation.duration = (if (isSlow) 300 else 150).toLong()
                alphaAnimation.interpolator =
                    MaterialInterpolator.instance
                view.clearAnimation()
                view.startAnimation(alphaAnimation)
                view.visibility = View.GONE
            }
        } else {
            view.visibility = View.GONE
        }
    }

    fun goneViews(vararg views: View?) {
        goneViews(true, *views)
    }

    fun goneViews(isAnimated: Boolean, vararg views: View?) {
        goneViews(isAnimated, true, *views)
    }

    fun goneViews(isAnimated: Boolean, isSlow: Boolean, vararg views: View?) {
        for (view in views) {
            goneView(view, isAnimated, isSlow)
        }
    }

    fun goneViews(views: Collection<View?>?) {
        goneViews(true, views)
    }

    fun goneViews(isAnimated: Boolean, views: Collection<View?>?) {
        goneViews(isAnimated, true, views)
    }

    fun goneViews(isAnimated: Boolean, isSlow: Boolean, views: Collection<View?>?) {
        if (views == null) {
            return
        }
        for (view in views) {
            goneView(view, isAnimated, isSlow)
        }
    }

    @JvmOverloads
    fun hideView(view: View?, isAnimated: Boolean = true, isSlow: Boolean = true) {
        if (view == null) {
            return
        }

        if (isAnimated) {
            if (view.visibility != View.INVISIBLE) {
                val alphaAnimation = AlphaAnimation(1f, 0f)
                alphaAnimation.duration = (if (isSlow) 300 else 150).toLong()
                alphaAnimation.interpolator =
                    MaterialInterpolator.instance
                view.clearAnimation()
                view.startAnimation(alphaAnimation)
                view.visibility = View.INVISIBLE
            }
        } else {
            view.visibility = View.INVISIBLE
        }
    }

    fun hideViews(vararg views: View?) {
        hideViews(true, *views)
    }

    fun hideViews(isAnimated: Boolean, vararg views: View?) {
        hideViews(isAnimated, true, *views)
    }

    fun hideViews(isAnimated: Boolean, isSlow: Boolean, vararg views: View?) {
        for (view in views) {
            hideView(view, isAnimated, isSlow)
        }
    }

    fun hideViews(views: Collection<View?>?) {
        hideViews(true, views)
    }

    fun hideViews(isAnimated: Boolean, views: Collection<View?>?) {
        hideViews(isAnimated, true, views)
    }

    fun hideViews(isAnimated: Boolean, isSlow: Boolean, views: Collection<View?>?) {
        if (views == null) {
            return
        }
        for (view in views) {
            hideView(view, isAnimated, isSlow)
        }
    }

    fun zoomOutViews(vararg views: View?) {
        for (view in views) {
            zoomOutView(view)
        }
    }

    fun zoomInViews(vararg views: View?) {
        for (view in views) {
            zoomInView(view)
        }
    }

    fun slideUpShow(view: View) {
        view.visibility = View.VISIBLE
        val animate = TranslateAnimation(0f, 0f, view.height.toFloat(), 0f)
        animate.duration = 300
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    fun slideUpHide(view: View) {
        val animate = TranslateAnimation(0f, 0f, 0f, (-view.height).toFloat())
        animate.duration = 300
        animate.fillAfter = true
        view.startAnimation(animate)
        view.visibility = View.GONE
    }

    fun slideDownShow(view: View) {
        view.visibility = View.VISIBLE
        val animate = TranslateAnimation(0f, 0f, view.height.toFloat(), 0f)
        animate.duration = 300
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    fun slideDownHide(view: View) {
        val animate = TranslateAnimation(0f, 0f, 0f, view.height.toFloat())
        animate.duration = 300
        animate.fillAfter = true
        view.startAnimation(animate)
        view.visibility = View.GONE
    }

    fun zoomOutView(view: View?) {
        if (view == null) {
            return
        }


        if (view.visibility != View.INVISIBLE) {
            val scaleAnimation = ScaleAnimation(
                1f,
                0f,
                1f,
                0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            scaleAnimation.duration = 150
            scaleAnimation.interpolator =
                MaterialInterpolator.instance
            view.clearAnimation()
            view.startAnimation(scaleAnimation)
            view.visibility = View.INVISIBLE
        }

    }


    fun zoomOutView(view: View?, goneView: Boolean) {
        if (!goneView) {
            zoomOutView(view)
            return
        }

        if (view == null) {
            return
        }

        if (view.visibility != View.GONE) {
            val scaleAnimation = ScaleAnimation(
                1f,
                0f,
                1f,
                0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            scaleAnimation.duration = 150
            scaleAnimation.interpolator =
                MaterialInterpolator.instance
            view.clearAnimation()
            view.startAnimation(scaleAnimation)
            view.visibility = View.GONE
        }
    }

    fun zoomInView(view: View?) {
        if (view == null) {
            return
        }

        if (view.visibility != View.VISIBLE) {
            val scaleAnimation = ScaleAnimation(
                0f,
                1f,
                0f,
                1f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            scaleAnimation.duration = 150
            scaleAnimation.interpolator =
                MaterialInterpolator.instance
            view.clearAnimation()
            view.startAnimation(scaleAnimation)
            view.visibility = View.VISIBLE
        }

    }

    @JvmOverloads
    fun showView(view: View?, isAnimated: Boolean = true, isSlow: Boolean = true) {
        if (view == null) {
            return
        }

        if (isAnimated) {
            if (view.visibility != View.VISIBLE) {
                val alphaAnimation = AlphaAnimation(0f, 1f)
                alphaAnimation.duration = (if (isSlow) 300 else 150).toLong()
                alphaAnimation.interpolator =
                    MaterialInterpolator.instance
                view.clearAnimation()
                view.startAnimation(alphaAnimation)
                view.visibility = View.VISIBLE
            }
        } else {
            view.visibility = View.VISIBLE
        }
    }

    fun showViews(vararg views: View?) {
        showViews(true, *views)
    }

    fun showViews(isAnimated: Boolean, vararg views: View?) {
        showViews(isAnimated, true, *views)
    }

    fun showViews(isAnimated: Boolean, isSlow: Boolean, vararg views: View?) {
        for (view in views) {
            showView(view, isAnimated, isSlow)
        }
    }

    fun showViews(views: Collection<View?>?) {
        showViews(true, views)
    }

    fun showViews(isAnimated: Boolean, views: Collection<View?>?) {
        showViews(isAnimated, true, views)
    }

    fun showViews(isAnimated: Boolean, isSlow: Boolean, views: Collection<View?>?) {
        if (views == null) {
            return
        }
        for (view in views) {
            showView(view, isAnimated, isSlow)
        }
    }

    fun blendColors(color1: Int, color2: Int, amount: Float, inverse: Boolean): Int {
        var amount = amount
        val alphaChannel: Byte = 24
        val redChannel: Byte = 16
        val greenChannel: Byte = 8
        val blueChannel: Byte = 0

        if (inverse) {
            amount = 1.0f - amount
        }
        val inverseAmount = 1.0f - amount

        val a =
            ((color1 shr alphaChannel.toInt() and 0xff).toFloat() * amount + (color2 shr alphaChannel.toInt() and 0xff).toFloat() * inverseAmount).toInt() and 0xff
        val r =
            ((color1 shr redChannel.toInt() and 0xff).toFloat() * amount + (color2 shr redChannel.toInt() and 0xff).toFloat() * inverseAmount).toInt() and 0xff
        val g =
            ((color1 shr greenChannel.toInt() and 0xff).toFloat() * amount + (color2 shr greenChannel.toInt() and 0xff).toFloat() * inverseAmount).toInt() and 0xff
        val b =
            ((color1 and 0xff).toFloat() * amount + (color2 and 0xff).toFloat() * inverseAmount).toInt() and 0xff

        return a shl alphaChannel.toInt() or (r shl redChannel.toInt()) or (g shl greenChannel.toInt()) or (b shl blueChannel.toInt())
    }

    fun elevateView(view: View, scale: Float) {
        elevateView(view, true, scale)
    }

    @JvmOverloads
    fun elevateView(view: View?, isAnimated: Boolean = true, scale: Float = 1.1f) {
        if (view == null) {
            return
        }


        val scaleAnimation = ScaleAnimation(
            1.0f,
            scale,
            1.0f,
            scale,
            Animation.RELATIVE_TO_SELF,
            0.5.toFloat(),
            Animation.RELATIVE_TO_SELF,
            0.5.toFloat()
        )
        scaleAnimation.duration = (if (isAnimated) 150 else 0).toLong()
        scaleAnimation.interpolator =
            MaterialInterpolator.instance
        scaleAnimation.fillAfter = true
        view.clearAnimation()
        view.startAnimation(scaleAnimation)

    }

    @JvmOverloads
    fun demoteView(view: View?, isAnimated: Boolean = true) {
        if (view == null) {
            return
        }

        if (isAnimated) {
            val scaleAnimation = ScaleAnimation(
                1.1f,
                1.0f,
                1.1f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5.toFloat(),
                Animation.RELATIVE_TO_SELF,
                0.5.toFloat()
            )
            scaleAnimation.duration = (if (isAnimated) 150 else 0).toLong()
            scaleAnimation.interpolator =
                MaterialInterpolator.instance
            scaleAnimation.fillAfter = true
            view.clearAnimation()
            view.startAnimation(scaleAnimation)
        }
    }

    //    public static void expand(final View v, int targetHeight) {
    //
    //        v.measure(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
    //
    //        final int initialHeight = new Integer(v.getLayoutParams().height);
    //
    //        v.getLayoutParams().height = initialHeight;
    //        Animation a = new ExpandAnimation(v, targetHeight, initialHeight);
    //
    //        a.setDuration(/*(targetHeight > 0 ? targetHeight : initialHeight / Screen.dp(1))*/150);
    //        a.setInterpolator(MaterialInterpolator.getInstance());
    //        v.startAnimation(a);
    //        if (targetHeight == 0) {
    //            v.setVisibility(View.INVISIBLE);
    //        } else {
    //            v.setVisibility(View.VISIBLE);
    //        }
    //    }

    fun wave(layers: Array<View>, scale: Float, duration: Int, offset: Float) {
        var step = 0

        for (l in layers) {
            wave(
                l,
                scale,
                duration,
                1.toFloat() / layers.size * step.toFloat() * offset
            )
            step++
        }
    }

    fun wave(layer: View, scale: Float, duration: Int, stepOffset: Float) {
        val scaleAnimation = ScaleAnimation(
            1.0f,
            scale,
            1.0f,
            scale,
            Animation.RELATIVE_TO_SELF,
            0.5.toFloat(),
            Animation.RELATIVE_TO_SELF,
            0.5.toFloat()
        )
        scaleAnimation.duration = duration.toLong()

        scaleAnimation.interpolator =
            OffsetCycleInterpolator(stepOffset)
        scaleAnimation.repeatCount = Animation.INFINITE
        layer.clearAnimation()
        layer.startAnimation(scaleAnimation)
    }

    fun expandView(v: View, targetHeight: Int, initialHeight: Int, after: After) {

        val a =
            ExpandAnimation(v, targetHeight, initialHeight)

        a.duration =
            (if (targetHeight > initialHeight) targetHeight else initialHeight / Screen.dp(
                1.0f
            )).toLong()
        a.interpolator = MaterialInterpolator.instance
        v.clearAnimation()
        a.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                after.doAfter()
            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })
        v.startAnimation(a)

    }

    private class ExpandAnimation(
        private val v: View,
        private val targetHeight: Int,
        private val initialHeight: Int
    ) : Animation() {
        private var currentHeight: Int = 0

        init {
            this.currentHeight = initialHeight
        }

        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
            if (targetHeight > initialHeight) {
                currentHeight =
                    (targetHeight * interpolatedTime - initialHeight * interpolatedTime + initialHeight).toInt()
            } else {
                currentHeight =
                    (initialHeight.toFloat() - initialHeight * interpolatedTime - targetHeight * (1f - interpolatedTime) + targetHeight).toInt()
            }

            v.layoutParams.height = currentHeight
            v.requestLayout()
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }


    fun getViewInset(view: View?, statusBarHeight: Int): Int {
        var view = view
        if (view == null || view.rootView == null) {
            return 0
        }

        view = view.rootView

        if (Build.VERSION.SDK_INT < 21 || view!!.height == Screen.getHeight() || view.height == Screen.getHeight() - statusBarHeight) {
            return 0
        }

        try {
            val mAttachInfoField = View::class.java.getDeclaredField("mAttachInfo")
            mAttachInfoField.isAccessible = true
            val mAttachInfo = mAttachInfoField.get(view)
            if (mAttachInfo != null) {
                val mStableInsetsField = mAttachInfo.javaClass.getDeclaredField("mStableInsets")
                mStableInsetsField.isAccessible = true
                val insets = mStableInsetsField.get(mAttachInfo) as Rect
                return insets.bottom
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return 0
    }

    interface After {
        fun doAfter()
    }
}
