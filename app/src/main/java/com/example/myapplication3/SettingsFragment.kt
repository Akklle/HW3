package com.example.myapplication3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication3.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {



    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)

        with(binding) {
            btnFavourite3.setOnClickListener {
                findNavController().navigate(
                    R.id.action_settingsFragment_to_usersFragment,
                    UsersFragment.createBundle(
                        ("Settings Fragment").toString()
                    )
                )
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}