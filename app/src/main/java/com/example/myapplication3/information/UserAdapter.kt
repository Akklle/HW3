package com.example.myapplication3.information

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.myapplication3.databinding.ItemUserBinding

class UserAdapter(
    private val list: List<User>,
    private val glide: RequestManager,
    private val onItemClick: (User) -> Unit,
): RecyclerView.Adapter<UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder = UserHolder(
        binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onItemClick = onItemClick
    )

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


}