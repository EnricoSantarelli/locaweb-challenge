package br.com.fiap.locawebchallenge.shared.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_message")
data class Message (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val recipient: User,
    val sender: User,
    val message: String = ""
)