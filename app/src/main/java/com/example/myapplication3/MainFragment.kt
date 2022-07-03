package com.example.myapplication3

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication3.databinding.FragmentMainBinding
import android.os.Bundle as Bundle

class MainFragment : Fragment(R.layout.fragment_main) {


    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        with(binding) {
            btnFavourite1.setOnClickListener {
                findNavController().navigate(
                    R.id.action_mainFragment_to_usersFragment,
                    UsersFragment.createBundle(
                        ("Main Fragment").toString()
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