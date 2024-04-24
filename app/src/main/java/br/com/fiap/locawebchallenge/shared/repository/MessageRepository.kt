package br.com.fiap.locawebchallenge.shared.repository

import android.content.Context
import br.com.fiap.locawebchallenge.shared.db.SQLiteDb
import br.com.fiap.locawebchallenge.shared.models.Message
import br.com.fiap.locawebchallenge.shared.models.User

class MessageRepository(context: Context) {
    private val db = SQLiteDb.getDatabase(context).messageDAO()

    fun sendMessage(message: Message): Unit {
        db.sendMessage(message)
    }

    fun getMessagesReceived(recipient: String): Array<Message> {
        return db.getMessagesReceived(recipient)
    }

    fun getMessagesSent(sender: String): Array<Message> {
        return db.getMessagesSent(sender)
    }
}