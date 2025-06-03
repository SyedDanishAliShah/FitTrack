package com.example.fittrack.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fittrack.dataclass.FitnessActivity
import com.example.fittrack.viewmodel.FitnessViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun AddEditScreen(
    navController: NavController,
    viewModel: FitnessViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Activity Name") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = duration, onValueChange = { duration = it }, label = { Text("Duration (mins)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = type, onValueChange = { type = it }, label = { Text("Type (e.g., Running)") })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (name.isNotBlank() && duration.isNotBlank() && type.isNotBlank()) {
                viewModel.addActivity(
                    FitnessActivity(
                        name = name,
                        durationInMinutes = duration.toIntOrNull() ?: 0,
                        date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date()),
                        type = type
                    )
                )
                navController.popBackStack()
            } else {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Save")
        }
    }
}
