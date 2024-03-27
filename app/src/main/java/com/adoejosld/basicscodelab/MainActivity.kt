package com.adoejosld.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adoejosld.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var shouldShowOnboarding by remember { mutableStateOf(true) }
    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }

}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = listOf(
        "Android",
        "Kotlin",
        "Jetpack Compose",
        "by Android Studio",
        "Aramis Doejo, Médico General / Ecografísta"
    )
) {
    Column(
        modifier = modifier
            .padding(vertical = 4.dp)
    ) {
        for (name in names)
            Greeting(name = name)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 2.dp, horizontal = 4.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(
                    text = "Hello...", color = Color.Black
                )
                Text(
                    text = "$name!", color = Color.Red
                )
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Mostrar -" else "Mostrar +")
            }
        }
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido a Basics Codelab")
        Button(
            modifier = modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continuar")
        }
    }
}

// Vistas Previas de las pantallas
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun ShouldShowOnboardingPreview() {
    BasicsCodelabTheme {
        OnboardingScreen(onContinueClicked = { })
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun MyAppPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingsPreview() {
    BasicsCodelabTheme {
        Greetings()
    }
}