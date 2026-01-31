package com.example.remedialucp2_077.view.uicontroller


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.room.Room
import androidx.compose.ui.platform.LocalContext
import com.example.remedialucp2_077.database.AppDatabase
import com.example.remedialucp2_077.repository.LibraryRepository
import com.example.remedialucp2_077.view.LibraryScreen
import com.example.remedialucp2_077.viewmodel.LibraryViewModel

@Composable
fun LibraryApp(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "library.db"
    ).build()

    val repo = LibraryRepository(db)
    val vm = LibraryViewModel(repo)

    LibraryScreen(vm = vm)
}
