package br.com.fiap.locawebchallenge.modules.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.locawebchallenge.shared.composables.BackBtn
import br.com.fiap.locawebchallenge.shared.composables.DefaultBtn
import br.com.fiap.locawebchallenge.shared.composables.DefaultTxtField
import br.com.fiap.locawebchallenge.shared.composables.TitleBanner
import br.com.fiap.locawebchallenge.shared.models.User
import br.com.fiap.locawebchallenge.shared.utils.encrypter

@Composable
fun LoginView(navController: NavController, viewModel: LoginViewModel) {
    val email by viewModel.email.observeAsState(initial = "")
    val password by viewModel.password.observeAsState(initial = "")

    Box {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            BackBtn(navController)
            TitleBanner(title = "Entrar com conta")
            Spacer(modifier = Modifier.height(32.dp))
            DefaultTxtField(
                "Email",
                keyboardType = KeyboardType.Email,
                onValueChange = { viewModel.setEmail(it) },
                value = email,
            )
            Spacer(modifier = Modifier.height(16.dp))
            DefaultTxtField(
                "Senha",
                keyboardType = KeyboardType.Password,
                onValueChange = { viewModel.setPassword(it) },
                value = password,
            )
            Spacer(modifier = Modifier.height(32.dp))
            DefaultBtn(title = "Entrar", onClick = {})
        }
    }
}