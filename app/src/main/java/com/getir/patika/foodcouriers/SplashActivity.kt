package com.getir.patika.foodcouriers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private var userId: String? = "sdsdasds"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handleInsets()

        CoroutineScope(Dispatchers.Main).launch {
            delay(SPLASH_TIME)

            userId?.let {
                startActivity(MainActivity.callIntent(this@SplashActivity))
            } ?: run {
                startActivity(OnboardingActivity.callIntent(this@SplashActivity))
            }
        }
    }

    private fun handleInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.splash_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }
    }

    companion object {
        private const val SPLASH_TIME = 2000L
    }
}
