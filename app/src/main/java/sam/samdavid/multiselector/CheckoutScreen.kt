package sam.samdavid.multiselector

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import sam.samdavid.multiselector.models.ClientModel
import sam.samdavid.multiselector.models.TicketTypeModel
import sam.samdavid.multiselector.ui.theme.BackGround
import sam.samdavid.multiselector.ui.theme.MultiSelectorTheme
import sam.samdavid.multiselector.viewmodel.AppViewModel


@Composable
fun CheckoutScreen() {
    val regular = TicketTypeModel(id = "reg_ticket", amount = "Ksh. 1,000", name = "REGULAR TICKET")
    val vip = TicketTypeModel(id = "vip_ticket", amount = "Ksh. 2,500", name = "VIP TICKET")
    val vvip = TicketTypeModel(id = "vvip_ticket", amount = "Ksh. 5,000", name = "VVIP TICKET")
    val ticketTypes = listOf(regular, vip, vvip)


    val viewModel = viewModel<AppViewModel>()
    val ticketTitle = viewModel.ticketTitle

    val selectedTicketTypes = viewModel.getTickets().value.tickets

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackGround
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 16.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 1.dp,
            backgroundColor = Color.White,

            ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)

            ) {

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
                        TicketType(
                            ticketTypeModel = ticketType,
                            clientDetails = ClientModel()
                        )
                    }
                }

                item {
                    Text(
                        text = "Check-Out Details:",
                        modifier = Modifier
                            .padding(top = 16.dp, start = 8.dp, bottom = 16.dp)
                    )
                }

                item {
                    selectedTicketTypes.forEach { ticketType ->
                        val ticketsQuantity = ticketType.quantity
                        for (count in 0..ticketsQuantity.toInt()){
                            if (count > 0 && ticketType.name != ticketTitle.toString()){
                                ClientDetails(title = "Enter ${ticketType.name} $count details:")
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