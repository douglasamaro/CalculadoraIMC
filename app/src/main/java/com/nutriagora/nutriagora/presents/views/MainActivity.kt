package com.nutriagora.nutriagora.presents.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.ExtraBold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.nutriagora.nutriagora.domain.formatt.FormartterDecimal
import com.nutriagora.nutriagora.domain.model.IMC
import com.nutriagora.nutriagora.ui.theme.NutriAgoraTheme
import com.nutriagora.nutriagora.ui.theme.*

class MainActivity : ComponentActivity() {

        var pesoConta: String = ""
        var alturaConta: String = ""
        var titulo: String = "Calcular IMC"
        var msg: String = "----"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriAgoraTheme {
                Surface(color = background) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()) {
                        Menu()
                        Root()
                    }
                }
            }
        }
    }

    fun Calcular() {
        if (pesoConta.isEmpty() || alturaConta.isEmpty()) {
            msg = "Preencha todos os campos"
        } else if (alturaConta.toDouble() > 3) {
            msg = "digite a altura em metros \n" +
                    "Exemplo: 1.7"
        }
        else {
            val brutoResultIMC: Double = IMC(pesoConta.toDouble(), alturaConta.toDouble()).CalcularIMC()
            val resultIMC = FormartterDecimal().formartar(brutoResultIMC)
            intent = Intent(this@MainActivity, ResultadoContatoNutri::class.java)
            intent.putExtra("IMC", resultIMC)
            startActivity(intent)
        }
    }


    @Composable
    fun Root() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 25.dp, end = 25.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Title(titulo)
            Alert(msg)
            PesoInput()
            AlturaInput()
            CalcularButton()
        }
    }
    @Composable
    fun Menu() {
        TopAppBar(
            title = {
                Text(
                "NutriAgora",
                    style = typography.h2,
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
    fun Alert(conteudo: String) {
        Text(
            conteudo,
            style = typography.h4,
            color = red,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
    }

    @Composable
    fun Title(conteudo: String) {
        Text(
            conteudo,
            style = typography.h1,
            color = texte,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp)
        )
    }

    @Composable
    fun PesoInput() {
        val peso = remember { mutableStateOf(TextFieldValue("")) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        ) {
            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    textColor = texte
                ),
                shape = RoundedCornerShape(20),
                value = peso.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { peso.value = it },
                placeholder = {
                    Text(
                        text = "digite em kg",
                        style = com.nutriagora.nutriagora.ui.theme.typography.body1,
                        color = texte
                    )
                },
                label = {
                    Text(
                        text = "seu peso",
                        style = com.nutriagora.nutriagora.ui.theme.typography.body1,
                        color = texte
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
        }
      pesoConta = peso.value.text.toString()
    }

    @Composable
    fun AlturaInput() {
        val altura = remember { mutableStateOf(TextFieldValue("")) }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        ) {
            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    textColor = texte
                ),
                shape = RoundedCornerShape(20),
                value = altura.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { altura.value = it },
                placeholder = {
                    Text(
                        text = "digite em cm",
                        style = com.nutriagora.nutriagora.ui.theme.typography.body1,
                        color = texte
                    )
                },
                label = {
                    Text(
                        text = "sua altura",
                        style = com.nutriagora.nutriagora.ui.theme.typography.body1,
                        color = texte
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
        }
        alturaConta = altura.value.text.toString()
    }

    @Composable
    fun CalcularButton() {

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                Calcular()
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
            Text("Calcular IMC", fontFamily = fonts, fontWeight = ExtraBold)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        NutriAgoraTheme {
            Root()
        }
    }
}