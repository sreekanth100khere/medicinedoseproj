package com.example.medicinedose

import LoginScreen
import SecondScreen
import android.app.Activity
import android.content.res.Resources.Theme
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicinedose.ui.theme.MedicineDoseTheme

import android.os.Bundle
import androidx.activity.viewModels
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.medicinedose.ui.theme.MedicineDoseTheme


class SecondActivity : ComponentActivity() {

    private lateinit var viewModel: MedicineVM
    private lateinit var adapter: MedicineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loggedInEmail:String = intent.getStringExtra("loggedInEmail").toString()
        setContent {
            MedicineDoseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier    = Modifier.fillMaxSize(),
                    color       = MaterialTheme.colorScheme.background
                ) {
                    SecondScreen(loggedInEmail)
                }
            }
        }
    }
}