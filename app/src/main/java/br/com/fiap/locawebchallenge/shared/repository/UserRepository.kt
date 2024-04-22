package br.com.fiap.locawebchallenge.shared.repository

import android.content.Context
import br.com.fiap.locawebchallenge.shared.db.SQLiteDb
import br.com.fiap.locawebchallenge.shared.models.User

class UserRepository(context: Context) {
    private val db = SQLiteDb.getDatabase(context).userDAO()

    fun createUser(user: User) {
        db.createUser(user)
    }

    fun getAllUsers(): Array<User> {
        return db.getAllUsers()
    }
}