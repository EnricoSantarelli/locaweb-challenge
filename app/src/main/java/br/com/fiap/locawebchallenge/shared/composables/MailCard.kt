package br.com.fiap.locawebchallenge.shared.composables

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import br.com.fiap.locawebchallenge.R
import br.com.fiap.locawebchallenge.shared.utils.getDate
import br.com.fiap.locawebchallenge.ui.theme.Typography

@Composable
fun MailCard(
    sender: String,
    message: String,
    date: Long,
    wasRead: Boolean
) {

    val date = getDate(date, "dd/MM/yyyy hh:mm:ss.SSS")
    Box(
        Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    sender, style = Typography.bodyLarge, color = colorResource(
                        id = R.color.primary
                    )
                )
                Text(
                    date, style = Typography.bodyLarge, color = colorResource(
                        id = R.color.secondary
                    )
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                message,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = Typography.labelSmall,
                color = colorResource(
                    id = R.color.primary
                )
            )
            if(!wasRead){
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(colorResource(id = R.color.primary))
                    )
                }
            }
        }
    }
}