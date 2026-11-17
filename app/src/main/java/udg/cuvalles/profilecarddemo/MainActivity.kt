package udg.cuvalles.profilecarddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import udg.cuvalles.profilecarddemo.ui.theme.ProfileCardDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileCardDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaTarjetasPerfil(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaTarjetasPerfil(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TarjetaDiseno1()
        TarjetaDiseno2()
    }
}

@Composable
fun TarjetaDiseno1() {
    var nombre by remember { mutableStateOf("Monkey D. Luffy") }
    var biografia by remember { mutableStateOf("Capitán de los Piratas de Sombrero de Paja\nFuturo Rey de los Piratas") }
    var modoEdicion by remember { mutableStateOf(false) }
    var siguiendo by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEEEEEE)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.portada),
                    contentDescription = "Imagen de portada",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .align(Alignment.TopCenter)
                )

                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Avatar de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFCCCCCC))
                        .border(4.dp, Color.White, CircleShape)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = nombre,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = biografia,
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp
                )

                if (modoEdicion) {
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Editar nombre") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = biografia,
                        onValueChange = { biografia = it },
                        label = { Text("Editar descripción") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { siguiendo = !siguiendo },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(
                        1.dp,
                        if (siguiendo) Color(0xFF0088FF) else Color(0xFFBDBDBD)
                    )
                ) {
                    Text(
                        text = if (siguiendo) "Siguiendo" else "Seguir",
                        color = if (siguiendo) Color(0xFF0088FF) else Color.DarkGray
                    )
                }

                Button(
                    onClick = { modoEdicion = !modoEdicion },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0088FF))
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (modoEdicion) android.R.drawable.ic_menu_save else android.R.drawable.ic_menu_edit
                        ),
                        contentDescription = "Icono acción",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (modoEdicion) "Guardar" else "Editar",
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun TarjetaDiseno2() {
    var mostrarCampoMensaje by remember { mutableStateOf(false) }
    var mensajeTexto by remember { mutableStateOf("") }
    var ultimoMensajeEnviado by remember { mutableStateOf("") }
    var verMasDetalles by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(2.dp, Color(0xFF0088FF)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEEEEEE)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Avatar de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFCCCCCC))
                        .border(4.dp, Color.White, CircleShape)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Monkey D. Luffy",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (verMasDetalles) {
                            "Recompensa: 3,000,000,000 Berries\nBarco: Thousand Sunny\nFruta: Hito Hito Modelo Nika"
                        } else {
                            "Recompensa: 3,000,000,000 Berries\nBarco: Thousand Sunny"
                        },
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        lineHeight = 18.sp
                    )
                    if (ultimoMensajeEnviado.isNotBlank()) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Mensaje enviado: \"$ultimoMensajeEnviado\"",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF0088FF)
                        )
                    }
                }
            }

            if (mostrarCampoMensaje) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = mensajeTexto,
                        onValueChange = { mensajeTexto = it },
                        label = { Text("Escribe un mensaje...") },
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (mensajeTexto.isNotBlank()) {
                                ultimoMensajeEnviado = mensajeTexto
                                mensajeTexto = ""
                                mostrarCampoMensaje = false
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0088FF))
                    ) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_send),
                            contentDescription = "Enviar mensaje",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { mostrarCampoMensaje = !mostrarCampoMensaje },
                    modifier = Modifier.width(120.dp),
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(1.dp, Color(0xFFBDBDBD))
                ) {
                    Text(
                        text = if (mostrarCampoMensaje) "Cerrar" else "Mensaje",
                        color = Color.DarkGray
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Button(
                    onClick = { verMasDetalles = !verMasDetalles },
                    modifier = Modifier.width(120.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0088FF))
                ) {
                    Text(
                        text = if (verMasDetalles) "Ver Menos" else "Ver Perfil",
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetasPreview() {
    ProfileCardDemoTheme {
        PantallaTarjetasPerfil()
    }
}