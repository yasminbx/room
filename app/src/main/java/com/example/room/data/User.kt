package com.example.room.data

import androidx.room.Entity
import androidx.room.vo.Entity

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Long = 0,
    val firstName: String,
    val lastName: String
)
