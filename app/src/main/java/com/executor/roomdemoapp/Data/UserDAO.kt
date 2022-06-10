package com.executor.roomdemoapp.Data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.executor.roomdemoapp.model.User

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("delete from user_table ")
    suspend fun deleteAllUser()

    @Query("Select * from user_table order by id asc")
    fun readAllData(): LiveData<List<User>>
}