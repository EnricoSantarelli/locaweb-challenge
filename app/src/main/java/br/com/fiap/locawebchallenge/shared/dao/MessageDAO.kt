package br.com.fiap.locawebchallenge.shared.dao

import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.locawebchallenge.shared.models.Message
import br.com.fiap.locawebchallenge.shared.models.User

interface MessageDAO {
    @Insert
    fun sendMessage(message: Message)

    @Query("SELECT * FROM tbl_message WHERE recipient = :recipient")
    fun getMessagesReceived(recipient: User): Array<Message>

    @Query("SELECT * FROM tbl_message WHERE sender = :sender")
    fun getMessagesSent(sender: User): Array<Message>
}