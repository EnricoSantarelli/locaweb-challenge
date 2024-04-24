package br.com.fiap.locawebchallenge.shared.composables

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.fiap.locawebchallenge.ui.theme.Typography

@Composable
fun DefaultBtn() {
    Button(onClick = { /*TODO*/ }, Modifier.width(200.dp)) {
        Text(
            text = "Entrar",
            style = Typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
    Text(
        text = "Criar conta",
        style = Typography.labelSmall,
        textAlign = TextAlign.Center
    )
}
