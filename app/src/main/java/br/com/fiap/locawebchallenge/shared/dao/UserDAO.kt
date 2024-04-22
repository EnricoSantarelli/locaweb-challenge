package br.com.fiap.locawebchallenge.shared.dao

import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.locawebchallenge.shared.models.User

interface UserDAO {
    @Insert
    fun createUser(user: User)

    @Query("SELECT * FROM tbl_user")
    fun getAllUsers(): Array<User>
}