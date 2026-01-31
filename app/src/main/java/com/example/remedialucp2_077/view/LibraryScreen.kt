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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.remedialucp2_077.R
import com.example.remedialucp2_077.viewmodel.LibraryViewModel

@Composable
fun LibraryScreen(vm: LibraryViewModel) {
    var title by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        vm.loadBooks()
    }

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = stringResource(R.string.title_app),
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(stringResource(R.string.hint_book_title)) },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                vm.addBook(title)
                title = ""
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(stringResource(R.string.btn_add_book))
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (vm.books.isEmpty()) {
            Text(stringResource(R.string.empty_book))
        } else {
            vm.books.forEach {
                Text("- ${it.title}")
            }
        }
    }
}
