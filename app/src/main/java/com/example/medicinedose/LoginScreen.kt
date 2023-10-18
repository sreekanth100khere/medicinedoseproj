import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.medicinedose.LoginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.medicinedose.SecondActivity


@Composable
fun LoginScreen() {
    val viewModel: LoginViewModel = viewModel()

    var isButtonEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.username,
            onValueChange = { newUsername ->
                viewModel.onUsernameChanged(newUsername)
                isButtonEnabled = newUsername.isNotBlank() && viewModel.password.isNotBlank()
            },
            label = {
                Text("Email")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textStyle = TextStyle(color = Color.Black),
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.password,
            onValueChange = { newPassword ->
                viewModel.onPasswordChanged(newPassword)
                isButtonEnabled = viewModel.username.isNotBlank() && newPassword.isNotBlank()
            },
            label = {
                Text("Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textStyle = TextStyle(color = Color.Black),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                if (viewModel.onLoginClicked()) {
                    // Handle successful login
                    // Goto Next Page..
                    val intent = Intent(context, SecondActivity::class.java)
                    var loggedInEmail:String = viewModel.username
                    intent.putExtra("loggedInEmail",loggedInEmail )
                    startActivity(context,intent,null)
                } else {
                    // Handle login failure
                }
            },
            enabled = isButtonEnabled,
            modifier = Modifier.border(10.dp, Color.Transparent).size(width = 200.dp, height = 60.dp)
        ) {
            Text(text = "Login")
        }
    }
}
