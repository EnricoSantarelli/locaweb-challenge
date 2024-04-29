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
            MailCard(
                sender = "enricosantarelli@hotmail.com",
                message = "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.",
                date = 1714252166133
            )
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
        FloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp),
            containerColor = colorResource(id = R.color.primary)
        ) {
            Icon(painter = painterResource(id = R.drawable.pencil_icon), contentDescription = "Pencil icon", tint = colorResource(id = R.color.secondary))
        }
    }
}