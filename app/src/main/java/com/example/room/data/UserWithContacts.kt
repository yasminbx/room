package com.example.room.data

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithContacts(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userOwnerId"
    )
    val contacts: List<ContactDetail>
)
