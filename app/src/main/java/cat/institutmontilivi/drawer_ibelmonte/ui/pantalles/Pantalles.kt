package cat.institutmontilivi.drawer_ibelmonte.ui.pantalles

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontilivi.categoriesnavigation.Dades.Arbres
import cat.institutmontilivi.categoriesnavigation.Dades.Muntanyes
import cat.institutmontilivi.categoriesnavigation.Dades.Rius
import cat.institutmontilivi.drawer_ibelmonte.R
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PLlistaArbres(titol: String, onContentClick: (Int) -> Unit) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    )
    {
        item { Text(text = titol, fontSize = 45.sp) }
        items(Arbres.dades){
            ListItem(headlineText = { Text(it.nom) }
                , leadingContent = { AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it.foto)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Arbre",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )
                }, modifier = Modifier.clickable { onContentClick(it.id) },
                supportingText = { Text("Altura Mitjana: " + it.alturaMitja.toString()) },
                shadowElevation = 10.dp)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PLlistaMuntanyes(titol: String, onContentClick: (Int) -> Unit) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    )
    {
        item { Text(text = titol, fontSize = 45.sp) }
        items(Muntanyes.dada){
            ListItem(headlineText = { Text(it.nom) }
                , leadingContent = { AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it.foto)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Muntanya",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )
                }, modifier = Modifier.clickable { onContentClick(it.id) },
                supportingText = { Text("Altura" + it.altura.toString()) },
                shadowElevation = 10.dp)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PLlistaRius(titol: String, onContentClick: (Int) -> Unit) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    )
    {
        item { Text(text = titol, fontSize = 45.sp) }
        items(Rius.dades){
            ListItem(headlineText = { Text(it.nom) }
                , leadingContent = { AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it.foto)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Riu",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )
                }, modifier = Modifier.clickable { onContentClick(it.id) },
                supportingText = { Text("Caudal: "+ it.caudal.toString()) },
                shadowElevation = 10.dp)
        }
    }
}
@Composable
fun PDetallArbres(id: Int){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ){
        val arbre = Arbres.dades.find{it.id == id}
        Log.d("IANBELMONTE","ID CORRECTA $id")

        if (arbre != null) {
            Text(
                "Nom: " + arbre.nom, modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(arbre.foto)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Arbre",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .weight(4F)
            )
            Text(text = "Arbre id: " + arbre.id.toString(), modifier = Modifier.align(
                Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(7.dp))
            Text(text = "Altura Mitja: " + arbre.alturaMitja.toString(), modifier = Modifier.align(
                Alignment.CenterHorizontally))
        }
    }
}
@Composable
fun PDetallMuntanyes(id: Int){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ){
        val muntanyes = Muntanyes.dada.find{it.id == id}
        Log.d("IANBELMONTE","ID CORRECTA $id")

        if (muntanyes != null) {
            Text(
                "Nom: " + muntanyes.nom, modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(muntanyes.foto)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Muntanya",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .weight(4F)
            )
            Text(text = "Id Muntanya" + muntanyes.id.toString(), modifier = Modifier.align(
                Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(7.dp))

            Text(text = "Latitud: " + muntanyes.latitud.toString(), modifier = Modifier.align(
                Alignment.CenterHorizontally))
            Text(text = "Longitud: " + muntanyes.longitud.toString(), modifier = Modifier.align(
                Alignment.CenterHorizontally))
            Text(text = "Altura: " + muntanyes.altura.toString(), modifier = Modifier.align(
                Alignment.CenterHorizontally))
        }
    }
}
@Composable
fun PDetallRius(id: Int){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ){
        val riu = Rius.dades.find{it.id == id}
        Log.d("IANBELMONTE","ID CORRECTA $id")

        if (riu != null) {
            Text(
                "Riu: " + riu.nom, modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(riu.foto)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Riu",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .weight(4F)
            )
            Text(text = "Id Riu" + riu.id.toString(), modifier = Modifier.align(
                Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(7.dp))

            Text(text = "Caudal: " + riu.caudal.toString(), modifier = Modifier.align(
                Alignment.CenterHorizontally))
            Text(text = "Longitud: " + riu.longitud.toString(), modifier = Modifier.align(
                Alignment.CenterHorizontally))
        }
    }
}
@Composable
fun Pantalla1()
{
    Text(text = "Pantalla 1")
}
@Composable
fun Pantalla2()
{
    Text(text = "Pantalla 2")
}