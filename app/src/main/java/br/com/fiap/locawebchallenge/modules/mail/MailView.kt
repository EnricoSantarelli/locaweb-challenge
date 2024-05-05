package br.com.fiap.locawebchallenge.modules.mail

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.locawebchallenge.R
import br.com.fiap.locawebchallenge.shared.composables.BackBtn
import br.com.fiap.locawebchallenge.shared.composables.TitleBanner
import br.com.fiap.locawebchallenge.shared.repository.MessageRepository
import br.com.fiap.locawebchallenge.shared.repository.UserRepository
import br.com.fiap.locawebchallenge.ui.theme.Typography

@Composable
fun MailView(navController: NavController, viewModel: MailViewModel, id: Int, userId: Int) {

    val context = LocalContext.current
    val message = viewModel.message.observeAsState()
    val userRepo = UserRepository(context)
    val user = userRepo.getUserById(userId)

    val messagesRepo = MessageRepository(context)

    try {
        viewModel.setMessage(messagesRepo.getMessage(id))
    } catch (e: Exception) {
        Log.e("Error", "${e.message}")
    }

    Box {
        Column {
            BackBtn(navController)
            Spacer(modifier = Modifier.height(32.dp))
            Column(Modifier.padding(horizontal = 16.dp)) {
                Row {
                    Text(
                        "DE: ", style = Typography.bodyLarge.copy(fontSize = 16.sp),
                        color = colorResource(
                            id = R.color.secondary
                        )
                    )
                    if (message.value != null) {
                        Text(
                            message.value!!.sender,
                            style = Typography.bodyLarge.copy(fontSize = 16.sp),

                            color = colorResource(
                                id = R.color.secondary
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row {
                        Text(
                            "PARA: ", style = Typography.bodyLarge.copy(fontSize = 16.sp),
                            color = colorResource(
                                id = R.color.secondary
                            )
                        )
                        if (message.value != null) {
                            Text(
                                message.value!!.recipient,
                                style = Typography.bodyLarge.copy(fontSize = 16.sp),
                                color = colorResource(
                                    id = R.color.secondary
                                )
                            )
                        }
                    }
                    if (message.value != null && (message.value!!.status != "DELETED" && user.email == message.value!!.recipient)) {
                        Log.i("WHY", message.value!!.status)
                        Log.i("WHY", message.value!!.recipient)
                        Log.i("WHY", user.email)
                        IconButton(onClick = {
                            try {
                                messagesRepo.deleteMessage(id)
                                navController.popBackStack()
                            } catch (e: Exception) {
                                Log.e("Error", "${e.message}")
                            }
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.trash_icon),
                                contentDescription = "Trash icon",
                                tint = colorResource(id = R.color.secondary)
                            )
                        }
                    } else {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(color = colorResource(R.color.gray))
                )
                Spacer(modifier = Modifier.height(16.dp))
                if (message.value != null) {
                    Text(
                        message.value!!.message,
                        style = Typography.labelSmall,
                        color = colorResource(
                            id = R.color.primary
                        )
                    )
                }
            }
        }
    }
}