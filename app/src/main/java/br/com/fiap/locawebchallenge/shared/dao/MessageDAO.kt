package br.com.fiap.locawebchallenge.shared.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.locawebchallenge.shared.models.Message
import br.com.fiap.locawebchallenge.shared.models.User

@Dao
interface MessageDAO {
    @Insert
    fun sendMessage(message: Message)

    @Query("SELECT * FROM tbl_message WHERE recipient = :recipient")
    fun getMessagesReceived(recipient: String): Array<Message>

    @Query("SELECT * FROM tbl_message WHERE sender = :sender")
    fun getMessagesSent(sender: String): Array<Message>
}