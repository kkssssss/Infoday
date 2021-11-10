package hkbu.edu.hkbu.comp.comp4097.infoday.ui.theme.event

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
data class Event(val title:String, val deptId: String, var saved:Boolean) {
    companion object {
        val data = listOf(
            Event(title = "Career Talks", deptId = "COMS", saved = false),
            Event(title = "Guided Tour", deptId = "COMS", saved = true),
            Event(title = "MindDrive Demo", deptId = "COMP", saved = false),
            Event(title = "Project Demo", deptId = "COMP", saved =  false)
        )
    }
}
@ExperimentalMaterialApi
@Composable
fun Events(nav: NavHostController, deptId: String = "") {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Events") },
            navigationIcon = {
                IconButton(onClick = { nav.popBackStack() }) {
                    // handler for physical back button
                    BackHandler(enabled = true, onBack = { nav.popBackStack() })
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        )
    }) {
        LazyColumn(modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 64.dp)) {
            items(Event.data.filter {it.deptId == deptId  }, itemContent = { item ->
                ListItem {
                    Text(item.title)
                }
                Divider()
            })
        }
    }
}