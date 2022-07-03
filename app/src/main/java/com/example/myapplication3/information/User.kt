package com.example.myapplication3.information

data class User(
    val id: String,
    val nickname: String,
    val realName: String,
    val age: String,
    val proffesion: String,
    val work_experience: String,
    val url: String = ""
)
