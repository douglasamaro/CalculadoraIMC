package com.nutriagora.nutriagora.presents.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nutriagora.nutriagora.ui.theme.*

class ResultadoContatoNutri : ComponentActivity() {

    var IMCResult: String = "--.--"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriAgoraTheme {
                Surface(color = background) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .fillMaxHeight()) {
                        Menu()
                        Root()
                    }
                }
            }
        }
        val intent = this.intent.extras
        IMCResult = intent?.getString("IMC").toString()

    }

    fun Cta() {
        Toast.makeText(this, "Direcionado", Toast.LENGTH_LONG).show()
    }

    @Composable
    fun Root() {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 25.dp, end = 25.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title()
            Column(modifier = Modifier
                .padding(start = 35.dp, end = 35.dp)) {
                    Resultado(IMCResult)
                }
            Description("Esse é uma descrição, uma chamada breve para o " +
                    "usuário entender seu IMC e Clicar no botão abaixo.")
            CtaButton()
        }
    }

    @Composable
    fun CtaButton() {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 30.dp)) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    Cta()
                },
                contentPadding = PaddingValues(
                    start = 12.dp,
                    top = 15.dp,
                    end = 12.dp,
                    bottom = 15.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = buttonback,
                    contentColor = background
                ),
                shape = RoundedCornerShape(30)
            ) {
                Text("Falar com o Nutri", fontFamily = fonts, fontWeight = FontWeight.ExtraBold)
            }
        }
    }

    @Composable
    fun Menu() {
        TopAppBar(
            title = {
                Text(
                    "NutriAgora",
                    style = MaterialTheme.typography.h2,
                    color = background,
                    modifier = Modifier.padding(5.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(topBar)
        )
    }

    @Composable
    fun Title() {
        Text(
            "O Resultado do seu IMC é",
            style = MaterialTheme.typography.h4,
            color = texte,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 10.dp)
        )
    }

    @Composable
    fun Resultado(conteudo: String) {
        Column(modifier = Modifier
            .padding(25.dp)
            .border(2.dp, texte, CircleShape)
            .aspectRatio(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                conteudo,
                style = MaterialTheme.typography.h3,
                color = texte
            )
        }
    }

    @Composable
    fun Description(conteudo: String) {
        Text(
            conteudo,
            style = MaterialTheme.typography.h4,
            color = texte,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, bottom = 25.dp, end = 25.dp)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        NutriAgoraTheme {
            Root()
        }
    }
}