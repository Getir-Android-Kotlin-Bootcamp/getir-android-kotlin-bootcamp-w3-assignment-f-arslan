package com.getir.patika.foodcouriers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.getir.patika.foodcouriers.databinding.FragmentAccountBinding
import com.getir.patika.foodmap.BaseFragment

class AccountFragment : BaseFragment<FragmentAccountBinding>() {
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAccountBinding {
        return FragmentAccountBinding.inflate(inflater, container, false)
    }

    override fun initializeViews() {
        binding.btnSetLocation.setOnClickListener {
            findNavController().navigate(AccountFragmentDirections.actionAccountFragment2ToLocationFragment())
        }
    }
}
