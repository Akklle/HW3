package com.example.myapplication3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication3.databinding.UserInformationBinding
import com.example.myapplication3.information.UserAdapter
import com.example.myapplication3.information.UserRepository
import com.google.android.material.snackbar.Snackbar

class UserInformation: Fragment(R.layout.user_information) {
    private var _binding: UserInformationBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = UserInformationBinding.bind(view)
        val id = arguments?.getString(ARG_TEXT)

        val user = UserRepository.users.find {it.id == id}
        binding.textId.text = user?.id
        binding.textNickname.text = user?.nickname
        binding.textRealName.text = user?.realName
        binding.textAge.text = user?.age
        binding.textProf.text = user?.proffesion
        binding.textYear.text = user?.work_experience

        Glide.with(this).load(user?.url).into(binding.img)

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