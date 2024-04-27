package br.com.fiap.locawebchallenge.modules.mails

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.locawebchallenge.shared.composables.Header
import br.com.fiap.locawebchallenge.shared.composables.TitleBanner
import br.com.fiap.locawebchallenge.shared.repository.UserRepository

@Composable
fun MailsView(navController : NavController, viewModel: MailsViewModel, id: Int){

    val context = LocalContext.current
    val repo = UserRepository(context)
    val user = repo.getUserById(id)
    Log.i("ID", id.toString())
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Header(isLogged = true, screenIndex = 1)
        Spacer(modifier = Modifier.height(16.dp))
        TitleBanner(title = "Caixa de entrada")
    }
}