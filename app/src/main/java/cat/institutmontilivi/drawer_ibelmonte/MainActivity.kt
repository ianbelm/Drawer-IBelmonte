package cat.institutmontilivi.drawer_ibelmonte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cat.institutmontilivi.drawer_ibelmonte.ui.Aplicacio
import cat.institutmontilivi.drawer_ibelmonte.ui.PantallaDeLaAplicacio
import cat.institutmontilivi.drawer_ibelmonte.ui.theme.DrawerIBelmonteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawerIBelmonteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaDeLaAplicacio {
                        Aplicacio()
                    }
                }
            }
        }
    }
}