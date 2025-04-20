package com.example.room.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDetailDao {
    @Insert
    suspend fun insertContact(contact: ContactDetail)

    @Query("SELECT * FROM ContactDetail WHERE userOwnerId = :userId")
    fun getContactsForUser(userId: Long): LiveData<List<ContactDetail>>
}
