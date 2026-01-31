package com.example.remedialucp2_077.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.remedialucp2_077.viewmodel.LibraryViewModel

@Composable
fun LibraryScreen(vm: LibraryViewModel) {
    var title by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        vm.loadBooks()
    }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Library App", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Judul Buku") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                vm.addBook(title)
                title = ""
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Tambah Buku")
        }

        Spacer(modifier = Modifier.height(16.dp))

        vm.books.forEach {
            Text("- ${it.title}")
        }
    }
}
