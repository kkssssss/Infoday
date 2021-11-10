package hkbu.edu.hkbu.comp.comp4097.infoday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import hkbu.edu.hkbu.comp.comp4097.infoday.ui.theme.InfodayTheme
import hkbu.edu.hkbu.comp.comp4097.infoday.ui.theme.info.SettingViewModel
import hkbu.edu.hkbu.comp.comp4097.infoday.ui.theme.nav.Nav

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkMode= SettingViewModel.darkMode
            InfodayTheme(darkTheme = darkMode.value) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
                    Nav()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InfodayTheme {
        Greeting("Android")
    }
}