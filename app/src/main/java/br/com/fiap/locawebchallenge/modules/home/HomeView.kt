package br.com.fiap.locawebchallenge.modules.home

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import br.com.fiap.locawebchallenge.R
import br.com.fiap.locawebchallenge.shared.composables.Header
import br.com.fiap.locawebchallenge.ui.theme.Typography

@Composable
fun HomeView() {
    Box {
        Column {
            Header(isLogged = false)
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    Modifier.background(color = Color(R.color.gray))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Segurança, customização e organização",
                            style = Typography.bodyLarge,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Bem-vindo ao LocaMail",
                            style = Typography.titleLarge,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Button(onClick = { /*TODO*/ }) {
                    Box() {
                        Text(
                            text = "Crie a sua conta",
                            style = Typography.bodyLarge,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Text(text = "Entrar", style = Typography.labelSmall, textAlign = TextAlign.Center)
            }
        }
    }
}