package com.example.room.data
@Entity(
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["userId"],
        childColumns = ["userOwnerId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ContactDetail(
    @PrimaryKey(autoGenerate = true) val contactId: Long = 0,
    val userOwnerId: Long,
    val type: String,
    val value: String
)
