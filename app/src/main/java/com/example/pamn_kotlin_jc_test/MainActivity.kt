package com.example.pamn_kotlin_jc_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pamn_kotlin_jc_test.ui.theme.PAMN_KotlinJC_testTheme
import com.example.pamn_kotlin_jc_test.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PAMN_KotlinJC_testTheme {
                Scaffold(modifier = Modifier.fillMaxWidth()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()), // Ensures scrolling
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        CenterHeader(
                            title = "Kotlin - Jetpack Compose Test",
                            subtitle = "Agustín Vizcaíno González"
                        )
                        Text(
                            text = "Originalmente, con el objetivo de hacer una tarea auto-propuesta, intenté crear un carrusel horizontal con un indicador de puntos y flechas. No obstante, demostró ser una tarea sorprendentemente complicada, ante la que me tuve que rendir después de cuatro horas de fracasos.",
                            textAlign = TextAlign.Justify
                        )
                        Text(
                            text = "En vista de ello, en su lugar, he decidido crear una vista sencilla que muestra secuencialmente las imágenes de algunos billetes de euro junto con algún detalle sobre el billete correspondiente.",
                            textAlign = TextAlign.Justify
                        )
                        EuroNoteDisplay(
                            "https://en.numista.com/catalogue/photos/zone_euro/668ef025cc6393.01514768-original.jpg",
                            "El billete de cinco euros es el más pequeño, con unas dimensiones de 120 x 62 milímetros (4,7 x 2,4 pulgadas) y un esquema de color gris."
                        )
                        EuroNoteDisplay(
                            "https://www.leftovercurrency.com/app/uploads/2016/11/10-euros-banknote-first-series-obverse-1.jpg",
                            "Los billetes de diez euros representan puentes y arcos/portales de la arquitectura románica (entre los siglos XI y XII)."
                        )
                        EuroNoteDisplay(
                            "https://en.numista.com/catalogue/photos/zone_euro/63a582672229f8.49500828-original.jpg",
                            "El billete de 50 euros es el más numeroso en circulación con una considerable diferencia, representando el 49% del número total de billetes de euro en 2023 (Wikipedia)."
                        )
                        Spacer(modifier = Modifier.height(16.dp)) // Add this to ensure there's space at the bottom
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun CenterHeader(title: String, subtitle: String = "") {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = Typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        if (subtitle.isNotEmpty()) {
            Text(
                text = subtitle,
                style = Typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        }
        HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
fun EuroNoteDisplay(ImageURL: String, FunFact: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageURL,
                contentDescription = "Euro note",
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = FunFact,
                style = Typography.bodyLarge,
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
