package com.example.myapplication3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication3.databinding.FragmentUsersBinding
import com.example.myapplication3.information.User
import com.example.myapplication3.information.UserAdapter
import com.example.myapplication3.information.UserRepository
import com.google.android.material.snackbar.Snackbar

class UsersFragment: Fragment(R.layout.fragment_users) {
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private var adapter: UserAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUsersBinding.bind(view)
        //dd.

        adapter = UserAdapter(UserRepository.users, Glide.with(this)) {

            findNavController().navigate(
            R.id.action_usersFragment_to_userInformation,
            UserInformation.createBundle(
                it.id
            )
        )
        }
        binding.rvFavourite.adapter = adapter

        with(binding) {
            btnBack.setOnClickListener() {
                findNavController().popBackStack(
                )
            }
        }
    }


    companion object {

        private const val ARG_TEXT = "amazing"

        fun createBundle(text: String): Bundle {
            val bundle = Bundle()
            bundle.putString(
                ARG_TEXT,
                text
            )
            return bundle
        }
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}