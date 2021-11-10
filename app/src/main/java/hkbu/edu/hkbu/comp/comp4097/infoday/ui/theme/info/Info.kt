package hkbu.edu.hkbu.comp.comp4097.infoday.ui.theme.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import hkbu.edu.hkbu.comp.comp4097.infoday.R
import hkbu.edu.hkbu.comp.comp4097.infoday.ui.theme.InfodayTheme

data class Contact(val office: String, val tel: String) {
    companion object {
        val data = listOf(
            Contact(office = "Admission Office", tel = "3411-2200"),
            Contact(office = "Emergencies", tel = "3411-7777"),
            Contact(office = "Health Services Center", tel = "3411-7447")
        )
    }
}
object SettingViewModel: ViewModel() {
    var darkMode: MutableState<Boolean> = mutableStateOf(false)
}

@ExperimentalMaterialApi
@Composable
fun Info() {
    Scaffold(topBar = { TopAppBar { Text("Info") }}) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.width(256.dp),
                painter = painterResource(id = R.drawable.ic_hkbu_logo),
                contentDescription = "Logo"
            )
            Text("HKBU InfoDay App", fontSize = MaterialTheme.typography.h4.fontSize)

            Row(modifier = Modifier.background(MaterialTheme.colors.primarySurface)) {
                Text(
                    "Important numbers",
                    style = TextStyle(color = Color.White,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                )
            }
            Contact.data.forEach { contact ->
                ListItem(text = { Text(contact.office) }, icon = {
                    Icon(painterResource(id = android.R.drawable.ic_menu_call), "Call")
                }, trailing = {
                    TextButton(onClick = {}) { Text(contact.tel) }
                })
            }
            Row(modifier = Modifier.background(MaterialTheme.colors.primarySurface)) {
                Text(
                    "Setting",
                    style = TextStyle(color = Color.White,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                )
            }
            ListItem(text = { Text("Dark mode") }, trailing = {
                var darkMode = SettingViewModel.darkMode
                Switch(checked = darkMode.value, onCheckedChange = { value ->
                    darkMode.value = value
                })
            })
        }
    }
}
@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InfodayTheme {
        Info()
    }
}