package sam.samdavid.multiselector

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import sam.samdavid.multiselector.models.TicketTypeModel
import sam.samdavid.multiselector.ui.theme.MultiSelectorTheme
import sam.samdavid.multiselector.viewmodel.AppViewModel


@Composable
fun CheckoutScreen() {
    val regular = TicketTypeModel(id = "reg_ticket", amount = "Ksh. 1,000", name = "REGULAR TICKET")
    val vip = TicketTypeModel(id = "vip_ticket", amount = "Ksh. 2,500", name = "VIP TICKET")
    val vvip = TicketTypeModel(id = "vip_ticket", amount = "Ksh. 5,000", name = "VVIP TICKET")
    val ticketTypes = listOf(regular, vip, vvip)

    val viewModel = viewModel<AppViewModel>()
    val selectedTicketType = viewModel.selectedTicketType
    val ticketsQuantity = selectedTicketType.quantity
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(8.dp),
            elevation = 0.dp,
            backgroundColor = Color.White,

            ) {
            LazyColumn {
                item {
                    Text(
                        text = "Select Tickets:",
                        modifier = Modifier
                            .padding(top = 16.dp, start = 8.dp)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    ticketTypes.forEach { ticketType ->
                        TicketType(ticketTypeModel = ticketType
                        )
                    }
                }
                item {
                    Text(
                        text = "Check-Out Details",
                        modifier = Modifier
                            .padding(top = 16.dp, start = 8.dp)
                    )
                }

                item {
                    for (count in 0..ticketsQuantity.toInt()){
                        if (count > 0){
                            selectedTicketType.tickets.forEach { ticketType ->
                                ClientDetails(title = "Enter ${ticketType.name} details:")
                            }
                        }
                    }
                }
                item {
                    for (count in 0..ticketsQuantity.toInt()){
                        if (count > 0){
                            selectedTicketType.tickets.forEach { ticketType ->
                                ClientDetails(title = "Enter ${ticketType.name} details:")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckOutPreview() {
    MultiSelectorTheme {
        CheckoutScreen()
    }
}