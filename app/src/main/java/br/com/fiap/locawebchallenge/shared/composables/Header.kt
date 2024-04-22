package br.com.fiap.locawebchallenge.shared.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.locawebchallenge.R
import br.com.fiap.locawebchallenge.ui.theme.Typography

@Composable
fun Header(isLogged: Boolean) {
    Box {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Row(
                modifier = Modifier
                    .padding(start = 24.dp, top = 16.dp, bottom = 16.dp, end = 4.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Locamail Logo",
                    modifier = Modifier.size(48.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    if (isLogged) {
                        Text(text = "Entrada", style = Typography.bodyLarge)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Enviados", style = Typography.bodyLarge)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Span", style = Typography.bodyLarge)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Excluídos", style = Typography.bodyLarge)
                    } else {
                        Text(text = "Entrar", style = Typography.bodyLarge)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Criar", style = Typography.bodyLarge)
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(color = Color(R.color.gray))
            )
        }
    }
}