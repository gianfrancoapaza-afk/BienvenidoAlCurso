package com.example.bienvenidoalcurso

// Importaciones de AndroidX y Kotlin (esenciales)
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// Importaciones de Jetpack Compose (Layouts, UI, y Modifiers)
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Divider // Necesario para la línea de separación
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector // Para manejar los iconos
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale // Para la imagen/logo
import com.example.composecomponentexploration.ComponentScreen

// Importaciones de Iconos de Material
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share

// Importación del Tema de la Aplicación
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

// 1. CLASE PRINCIPAL: Actualizada para llamar a BusinessCardApp()
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BienvenidoAlCursoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComponentScreen() // ¡Llamando a la nueva función de exploración!
                }
            }
        }
    }
}
// 2. FUNCIÓN PRINCIPAL: Contenedor de la Tarjeta de Presentación
@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        // Distribuye el espacio entre la sección de logo y la sección de contacto
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // A. SECCIÓN SUPERIOR: Logo y Nombre
        Column(
            modifier = Modifier.weight(1f), // Ocupa la mayor parte del espacio vertical
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Se usa el logo predeterminado de Android Studio
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Android Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Gianfranco Apaza",
                fontSize = 32.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 16.sp,
                color = Color(0xFF006400) // Verde oscuro
            )
        }

        // B. SECCIÓN INFERIOR: Contacto
        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Líneas divisorias y filas de contacto

            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
            ContactInfoRow(
                icon = Icons.Filled.Call,
                text = "+51 993484387"
            )

            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
            ContactInfoRow(
                icon = Icons.Filled.Share,
                text = "@gianfranco.apaza"
            )

            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
            ContactInfoRow(
                icon = Icons.Filled.Email,
                text = "gianfranco.apaza@android.com"
            )
        }
    }
}


// 3. FUNCIÓN AUXILIAR: Define la estructura de cada fila de contacto
@Composable
fun ContactInfoRow(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 48.dp), // Añade padding para mover el contenido
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006400), // Verde oscuro
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 16.sp, color = Color.Black)
    }
}


// 4. FUNCIÓN DE PREVISUALIZACIÓN
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BienvenidoAlCursoTheme {
        BusinessCardApp()
    }
}