package com.getir.patika.foodcouriers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.getir.patika.foodcouriers.databinding.ActivityTestBinding
import com.wada811.viewbindingktx.viewBinding

class TestActivity : AppCompatActivity(R.layout.activity_test) {

    private val binding by viewBinding(ActivityTestBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.button.setOnClickListener {
            findNavController(R.id.nav_main).navigate(R.id.homeFragment)
        }

    }
}