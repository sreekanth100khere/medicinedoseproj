import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.medicinedose.LoginViewModel
import java.util.Calendar


@Composable
fun SecondScreen(iLoggedInEmail:String) {
    val viewModel: LoginViewModel = viewModel()

    var isButtonEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val openDialog = remember { mutableStateOf(true)  }
        var message:String = ""
        when{
        openDialog.value -> {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(text = "Login Success.")
                },
                text = {
                    val c: Calendar = Calendar.getInstance()
                    val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)

                    if (timeOfDay >= 0 && timeOfDay < 12) {
                        message = " Good Morning"
                    } else if (timeOfDay >= 12 && timeOfDay < 16) {
                        message = " Good Afternoon"
                    } else if (timeOfDay >= 16 && timeOfDay < 21) {
                        message = " Good Evening"
                    } else if (timeOfDay >= 21 && timeOfDay < 24) {
                        message = " Good Night"
                    }

                    Text(message + "\r\n Email:" + iLoggedInEmail)
                },
                confirmButton = {
                    Button(
                        onClick = {
                            openDialog.value = false
                        }) {
                        Text("OK")
                    }
                }
            )
        }
     }
    }
}
