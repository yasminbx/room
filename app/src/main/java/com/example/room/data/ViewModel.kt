package com.example.room.data

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    private val userDao = db.userDao()
    private val contactDao = db.contactDetailDao()

    val users: LiveData<List<User>> = userDao.getAllUsers()

    fun insertUser(user: User) = viewModelScope.launch {
        userDao.insertUser(user)
    }

    fun insertContact(contact: ContactDetail) = viewModelScope.launch {
        contactDao.insertContact(contact)
    }

    fun getUserWithContacts(userId: Long): LiveData<UserWithContacts> {
        return userDao.getUserWithContacts(userId)
    }
}
