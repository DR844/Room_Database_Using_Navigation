package com.executor.roomdemoapp.repository

import androidx.lifecycle.LiveData
import com.executor.roomdemoapp.Data.UserDAO
import com.executor.roomdemoapp.model.User

class UserRepository(private val userDao: UserDAO) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUser() {
        userDao.deleteAllUser()
    }
}