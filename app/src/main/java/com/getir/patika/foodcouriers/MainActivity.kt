package com.getir.patika.foodcouriers

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.getir.patika.foodcouriers.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val TAG = "PATIKA"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding = ActivityMainBinding.inflate(layoutInflater)
        // setContentView(binding.root)
        // NavigationUI.setupWithNavController(binding.bottomNav, navHostFragment.navController)
        Log.v(TAG, "onCreate")
        // setContentView(R.layout.onboarding_favorities)
        /* tabLayout = findViewById(R.id.tab_account)
         viewPager2 = findViewById(R.id.viewpager_account)
         pagerAdapter = PagerAdapter(supportFragmentManager,lifecycle).apply {
             addFragment(CreateAccountFragment())
             addFragment(LoginAccountFragment())
         }
         viewPager2.adapter = pagerAdapter

         TabLayoutMediator(tabLayout,viewPager2){ tab, position ->
              when(position) {
                  0 -> {
                      tab.text = "Create Account"
                  }
                  1 -> {
                      tab.text = "Login Account"
                  }
              }

         }.attach()*/

        handleInsets()
    }


    private fun handleInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }
    }

    companion object {
        fun callIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy")
    }
}