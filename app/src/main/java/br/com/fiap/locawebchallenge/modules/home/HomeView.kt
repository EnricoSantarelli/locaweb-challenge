package br.com.fiap.locawebchallenge.modules.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.com.fiap.locawebchallenge.R

@Composable
fun HomeView() {
    Box {
        Column {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Locamail Logo")
        }
    }
}