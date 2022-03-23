package com.example.notcompose.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.notcompose.R
import com.example.notcompose.base.BaseActivity
import com.example.notcompose.databinding.ActivityHomeBinding
import com.example.notcompose.ui.indoor.IndoorActivity
import com.example.notcompose.ui.outdoor.OutdoorActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun routeIndoor(view: View) {
        startActivity(Intent(this@HomeActivity, IndoorActivity::class.java))
    }

    fun routeOutdoor(view: View) {
        startActivity(Intent(this@HomeActivity, OutdoorActivity::class.java))
    }
}