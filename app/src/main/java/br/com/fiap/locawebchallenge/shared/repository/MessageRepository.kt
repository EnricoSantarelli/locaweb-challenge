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

    fun deleteMessage(message: Message): Unit {
        db.deleteMessage(message)
    }
    fun getMessagesReceived(recipient: String): Array<Message> {
        return db.getMessagesReceived(recipient)
    }

    fun getMessagesSent(sender: String): Array<Message> {
        return db.getMessagesSent(sender)
    }

    fun getMessagesSpam(recipient: String): Array<Message> {
        return db.getMessagesSpam(recipient)
    }

    fun getMessagesDeleted(recipient: String): Array<Message> {
        return db.getMessagesDeleted(recipient)
    }
}