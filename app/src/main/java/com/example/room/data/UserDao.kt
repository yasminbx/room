package com.example.room.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM User")
    fun getAllUsers(): LiveData<List<User>>

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :id")
    fun getUserWithContacts(id: Long): LiveData<UserWithContacts>
}
