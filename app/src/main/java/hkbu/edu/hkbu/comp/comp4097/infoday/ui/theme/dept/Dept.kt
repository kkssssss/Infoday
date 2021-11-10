package hkbu.edu.hkbu.comp.comp4097.infoday.ui.theme.dept

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Dept (val name: String, val id: String) {
    companion object {
        val data = listOf(
            Dept("Computer Science", "COMP"),
            Dept("Communication Studies", "COMS")

        )
    }
}
@ExperimentalMaterialApi
@Composable
fun Dept(nav: NavHostController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Departments") }) }) {
        LazyColumn(modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 64.dp)) {
            items(Dept.data, itemContent= { item ->
                ListItem(secondaryText = {
                    Text(item.id)
                }, modifier = Modifier.clickable {

                }) {
                    Text(item.name)
                }
                Divider()
            })
        }
    }
}