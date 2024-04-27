package br.com.fiap.locawebchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.locawebchallenge.modules.home.HomeView
import br.com.fiap.locawebchallenge.modules.login.LoginView
import br.com.fiap.locawebchallenge.modules.login.LoginViewModel
import br.com.fiap.locawebchallenge.modules.mails.MailsView
import br.com.fiap.locawebchallenge.modules.mails.MailsViewModel
import br.com.fiap.locawebchallenge.modules.register.RegisterView
import br.com.fiap.locawebchallenge.modules.register.RegisterViewModel
import br.com.fiap.locawebchallenge.ui.theme.LocawebChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocawebChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home", builder = {
                        composable("home") {
                            HomeView(navController)
                        }
                        composable("register") {
                            RegisterView(navController, viewModel = RegisterViewModel())
                        }
                        composable("login"){
                            LoginView(navController, viewModel = LoginViewModel())
                        }
                        composable("mails/{id}",){
                            val id= it.arguments?.getInt("id")
                            MailsView(navController, viewModel = MailsViewModel(), id!!)
                        }
                    })
                }
            }
        }
    }
}