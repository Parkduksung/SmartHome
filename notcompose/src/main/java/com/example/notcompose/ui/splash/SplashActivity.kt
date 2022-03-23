package com.example.notcompose.ui.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import com.example.notcompose.R
import com.example.notcompose.base.BaseActivity
import com.example.notcompose.databinding.ActivitySplashBinding
import com.example.notcompose.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
    }

    private fun initUi() {

        /**
         * 애니메이션 관련 리스너
         */
        binding.lottieView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}

            /**
             * 애니메이션 cycle 이 끝났을때 나타내는 콜백 함수.
             */
            override fun onAnimationEnd(animation: Animator) {
                startActivity(Intent(this@SplashActivity, HomeActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                })
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationRepeat(animation: Animator) {}
        })
    }
}