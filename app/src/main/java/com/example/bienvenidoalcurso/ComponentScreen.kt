package com.example.composecomponentexploration

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme // Asumiendo que el tema es accesible

// ------------------------------------------------------------------
// A. CONTENEDOR: LazyColumn
// ------------------------------------------------------------------

@Composable
fun LazyColumnExample() {
    val itemsList = (0..50).toList()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text("LazyColumn (Lista Scrollable)", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, fontSize = 20.sp)
        }
        items(itemsList) { index ->
            Text("Elemento de la lista #$index")
            Divider()
        }
    }
}

// Características y Atributos:
// * **Descripción:** Un contenedor que renderiza elementos verticalmente, similar a RecyclerView en Android Views. Solo crea Composables para los elementos que están visibles en la pantalla, ahorrando memoria.
// * **Atributos Clave:** `items()` (para proveer la lista), `contentPadding`, `verticalArrangement`.

// ------------------------------------------------------------------
// B. CONTROL: Card
// ------------------------------------------------------------------

@Composable
fun CardExample() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Card (Tarjeta Elevada)", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Este control se usa para agrupar contenido y darle un aspecto elevado.")
        }
    }
}

// Características y Atributos:
// * **Descripción:** Un contenedor de superficie que muestra contenido relacionado en un formato atractivo con esquinas redondeadas y una sombra (elevación) que lo distingue del fondo.
// * **Atributos Clave:** `elevation` (controla la sombra), `shape` (controla la curvatura de la esquina), `colors`.

// ------------------------------------------------------------------
// C. CONTROL: OutlinedTextField
// ------------------------------------------------------------------

@Composable
fun OutlinedTextFieldExample() {
    var text by remember { mutableStateOf("Hola") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("OutlinedTextField") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

// Características y Atributos:
// * **Descripción:** Un campo de entrada de texto que muestra un borde delineado para contener el valor y la etiqueta (label).
// * **Atributos Clave:** `value` (el texto actual), `onValueChange` (función que maneja la entrada del usuario), `label`, `leadingIcon`, `trailingIcon`.


// ------------------------------------------------------------------
// D. Pantalla de Previsualización (para mostrar todos juntos)
// ------------------------------------------------------------------

@Composable
fun ComponentScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item { CardExample() }
        item { OutlinedTextFieldExample() }
        item { LazyColumnExample() }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentScreenPreview() {
    BienvenidoAlCursoTheme {
        ComponentScreen()
    }
}