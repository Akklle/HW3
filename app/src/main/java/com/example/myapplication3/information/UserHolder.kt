package com.example.myapplication3.information

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication3.databinding.ItemUserBinding

class UserHolder(
    val binding: ItemUserBinding,
    private val glide: RequestManager,
    private val onItemClick: (User) -> Unit,
    ): RecyclerView.ViewHolder (binding.root){

    private val options: RequestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    fun onBind(user: User) {
        with(binding) {
            tvNickname.text = user.nickname
            tvRealName.text = user.realName
            root.setOnClickListener{
                onItemClick(user)
            }

            glide
                .load(user.url)
                .into(ivCover)
        }
    }
}