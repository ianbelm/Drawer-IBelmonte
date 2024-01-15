package cat.institutmontilivi.drawer_ibelmonte.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import cat.institutmontilivi.drawer_ibelmonte.ui.pantalles.PDetallArbres
import cat.institutmontilivi.drawer_ibelmonte.ui.pantalles.PDetallMuntanyes
import cat.institutmontilivi.drawer_ibelmonte.ui.pantalles.PDetallRius
import cat.institutmontilivi.drawer_ibelmonte.ui.pantalles.PLlistaArbres
import cat.institutmontilivi.drawer_ibelmonte.ui.pantalles.PLlistaMuntanyes
import cat.institutmontilivi.drawer_ibelmonte.ui.pantalles.PLlistaRius
import cat.institutmontilivi.drawer_ibelmonte.ui.pantalles.Pantalla1
import cat.institutmontilivi.drawer_ibelmonte.ui.pantalles.Pantalla2

@Composable
fun GrafDeNavegacio(controladorDeNavegacio: NavHostController = rememberNavController(),
                    paddingValues: PaddingValues)
{
    NavHost(navController = controladorDeNavegacio, startDestination = CategoriaNavegacio.CategoriaArbres.rutaPrevia,
        modifier = Modifier.padding(paddingValues))
    {
        navigation(startDestination = Destinacio.LlistaArbres.rutaBase, route = CategoriaNavegacio.CategoriaArbres.rutaPrevia)
        {
            composable(route = Destinacio.LlistaArbres.rutaGenerica)
            {
                PLlistaArbres(titol = "Arbres", onContentClick = {id:Int -> controladorDeNavegacio.navigate(Destinacio.DetallArbre.CreaRutaAmbArguments(idArbre = id))})
            }
            composable(
                route = Destinacio.DetallArbre.rutaGenerica,
                arguments = Destinacio.DetallArbre.navArgs)
            {
                val n = it.arguments?.getInt(ArgumentDeNavegacio.ArbresContent.clau)
                requireNotNull(n)
                PDetallArbres(id = n)
            }
        }
        navigation(startDestination = Destinacio.LlistaMuntanyes.rutaBase,
            route = CategoriaNavegacio.CategoriaMuntanyes.rutaPrevia)
        {
            composable(route = Destinacio.LlistaMuntanyes.rutaGenerica)
            {
                PLlistaMuntanyes(titol = "Llista de muntanyes",
                    onContentClick = {id:Int -> controladorDeNavegacio.navigate(Destinacio.DetallMuntanyes.CreaRutaAmbArguments(idMuntanya = id))})
            }
            composable(
                route = Destinacio.DetallMuntanyes.rutaGenerica,
                arguments = Destinacio.DetallMuntanyes.navArgs)
            {
                val n = it.arguments?.getInt(ArgumentDeNavegacio.MuntanyesContent.clau)
                requireNotNull(n)
                PDetallMuntanyes(id=n)
            }
        }
        navigation(startDestination = Destinacio.LlistaRius.rutaBase,
            route = CategoriaNavegacio.CategoriaRius.rutaPrevia)
        {
            composable(route = Destinacio.LlistaRius.rutaGenerica)
            {
                PLlistaRius(titol = "Llista de Rius",
                    onContentClick = {id:Int -> controladorDeNavegacio.navigate(Destinacio.DetallRius.CreaRutaAmbArguments(idRius = id))})
            }
            composable(
                route = Destinacio.DetallRius.rutaGenerica,
                arguments = Destinacio.DetallRius.navArgs)
            {
                val n = it.arguments?.getInt(ArgumentDeNavegacio.RiusContent.clau)
                requireNotNull(n)
                PDetallRius(id=n)
            }
        }
        navigation(startDestination = Destinacio.LlistaCategory.rutaBase,
            route = CategoriaNavegacio.Category.rutaPrevia)
        {
            composable(route = Destinacio.LlistaCategory.rutaGenerica)
            {
                Pantalla1()
            }
        }
        navigation(startDestination = Destinacio.Llistacategory2.rutaBase,
            route = CategoriaNavegacio.category2.rutaPrevia)
        {
            composable(route = Destinacio.Llistacategory2.rutaGenerica)
            {
                Pantalla2()
            }
        }
    }
}

