package sam.samdavid.multiselector

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sam.samdavid.multiselector.ui.theme.MultiSelectorTheme

@Composable
fun ClientDetails(
    title: String
) {
    /**
     * title
     * first_name
     * last_name
     * phone
     * email
     */
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Text(text = title)

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                value = firstName
                ,
                onValueChange = {
                    firstName = it
                },
                label = {
                    Text(text = "First Name", fontSize = 12.sp)
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .weight(1f)
                    .border(
                        border = BorderStroke(width = 1.dp, color = Color.Gray),
                        shape = RoundedCornerShape(8.dp)
                    )

            )

            Spacer(modifier = Modifier.width(8.dp))

            TextField(
                value = "",
                onValueChange = {
                    lastName = it
                },
                label = {
                    Text(
                        text = "Last Name",
                        fontSize = 12.sp
                    )
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .weight(1f)
                    .border(
                        border = BorderStroke(width = 1.dp, color = Color.Gray),
                        shape = RoundedCornerShape(8.dp)
                    )

            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                value = "",
                onValueChange = {
                    email = it
                },
                label = {
                    Text(text = "Email", fontSize = 12.sp)
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .weight(1f)
                    .border(
                        border = BorderStroke(width = 1.dp, color = Color.Gray),
                        shape = RoundedCornerShape(8.dp)
                    )

            )

            Spacer(modifier = Modifier.width(8.dp))

            TextField(
                value = "",
                onValueChange = {
                    phoneNumber = it
                },
                label = {
                    Text(text = "Phone Number", fontSize = 12.sp)

                },
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .weight(1f)
                    .border(
                        border = BorderStroke(width = 1.dp, color = Color.Gray),
                        shape = RoundedCornerShape(8.dp)
                    )

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    MultiSelectorTheme {
        //ClientDetailsScreen(title = "VIP TICKET 1")
    }
}