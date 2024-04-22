package br.com.fiap.locawebchallenge.modules.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.fiap.locawebchallenge.shared.composables.Header
import br.com.fiap.locawebchallenge.ui.theme.Typography

@Composable
fun HomeView() {
    Box {
        Column {
            Header(isLogged = true)
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Segurança, customização e organização", style = Typography.titleLarge)
                Text(text = "Bem-vindo ao LocaMail")
                Button(onClick = { /*TODO*/ }) {
                    Box() {
                        Text(text = "Crie a sua conta")
                    }
                }
                Text(text = "Entrar")
            }
        }
    }
}