package com.getir.patika.foodcouriers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.getir.patika.foodcouriers.databinding.FragmentOnboardingCheapBinding
import com.getir.patika.foodmap.BaseFragment

class OnboardingCheapFragment : BaseFragment<FragmentOnboardingCheapBinding>() {
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOnboardingCheapBinding {
        return FragmentOnboardingCheapBinding.inflate(inflater, container, false)
    }

    override fun initializeViews() {
        binding.btNext.setOnClickListener {
            findNavController().navigate(OnboardingCheapFragmentDirections.actionOnboardingCheapFragmentToNavAccount())
        }
    }
}
