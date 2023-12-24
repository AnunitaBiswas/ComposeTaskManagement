package com.example.composetaskmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetaskmanagement.taskmanager.components.TaskComponent
import com.example.composetaskmanagement.taskmanager.components.WelcomeMsgComponent
import com.example.composetaskmanagement.ui.theme.ComposeTaskManagementTheme
import com.example.taskmanagementcompose.taskmanager.components.ProfileHeaderComponents
import com.example.taskmanagementcompose.taskmanager.data.taskList

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         val selectedScreen by remember { mutableStateOf(1) }
         val screens = listOf("Calendar", "Home", "Notification")
            ComposeTaskManagementTheme {
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                ) {
                    item { ProfileHeaderComponents() }
                    item {
                        Spacer(modifier = Modifier.height(30.dp))
                        WelcomeMsgComponent()
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                    items(taskList){
                        TaskComponent(task = it)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}