package br.com.fiap.locawebchallenge.modules.mails

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.locawebchallenge.R
import br.com.fiap.locawebchallenge.shared.composables.Header
import br.com.fiap.locawebchallenge.shared.composables.MailCard
import br.com.fiap.locawebchallenge.shared.composables.TitleBanner
import br.com.fiap.locawebchallenge.shared.repository.MessageRepository
import br.com.fiap.locawebchallenge.shared.repository.UserRepository
import br.com.fiap.locawebchallenge.ui.theme.Typography

@Composable
fun MailsView(navController: NavController, viewModel: MailsViewModel, id: Int) {

    val context = LocalContext.current
    val userRepo = UserRepository(context)
    val user = userRepo.getUserById(id)
    val messages = viewModel.messages.observeAsState()

    val messagesRepo = MessageRepository(context)

    try {
        viewModel.setMessages(messagesRepo.getMessagesReceived(user.email))
    } catch (e: Exception) {
        Log.i("Error", e.message!!)
    }

    Box{
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Header(isLogged = true, screenIndex = 1)
            Spacer(modifier = Modifier.height(16.dp))
            TitleBanner(title = "Caixa de entrada")
            if (messages.value != null && messages.value!!.isNotEmpty()) {
                messages.value!!.forEach {
                    MailCard(sender = it.sender, message = it.message, date = it.date)
                }
            } else {
                Text(
                    text = "Caixa de entrada vazia",
                    style = Typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.white)
                )
            }
        }
        FloatingActionButton(onClick = {
            navController.navigate("creation?id=$id") }, modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp),
            containerColor = colorResource(id = R.color.primary)
        ) {
            Icon(painter = painterResource(id = R.drawable.pencil_icon), contentDescription = "Pencil icon", tint = colorResource(id = R.color.secondary))
        }
    }
}