package sam.samdavid.multiselector

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import sam.samdavid.multiselector.models.ClientModel
import sam.samdavid.multiselector.models.TicketTypeModel
import sam.samdavid.multiselector.ui.theme.MultiSelectorTheme
import sam.samdavid.multiselector.viewmodel.AppViewModel

@Composable
fun TicketType(
    ticketTypeModel: TicketTypeModel,
    clientDetails: ClientModel,
) {
    val viewModel = viewModel<AppViewModel>()

    val quantityList = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    var selectedText by remember {
        mutableStateOf("")
    }

    val ticketsList = arrayListOf<TicketTypeModel>()

    var isExpanded by remember {
        mutableStateOf(false)
    }
    val icon = if (isExpanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    val focusManager = LocalFocusManager.current

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val (typeText, amountText, quantityDropDown, divider) = createRefs()
        Text(
            text = ticketTypeModel.name,
            style = TextStyle(fontSize = 13.sp),
            modifier = Modifier
                .constrainAs(typeText) {
                    top.linkTo(quantityDropDown.top)
                    start.linkTo(parent.start, margin = 8.dp)
                }
        )
        Text(
            text = ticketTypeModel.amount,
            style = TextStyle(fontSize = 13.sp),
            modifier = Modifier.constrainAs(amountText) {
                bottom.linkTo(quantityDropDown.bottom)
                start.linkTo(parent.start, margin = 8.dp)
            }
        )

        Column(
            modifier = Modifier
                .width(100.dp)
                .height(48.dp)
                .constrainAs(quantityDropDown) {
                    top.linkTo(parent.top, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                }
        ) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = {
                    viewModel._selectionState.value = it
                },
                textStyle = TextStyle(
                    fontSize = 13.sp
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = "",
                        Modifier
                            .clickable {
                                isExpanded = !isExpanded
                            }
                    )
                },
                keyboardActions = KeyboardActions {
                    focusManager.clearFocus(force = true)
                }
            )

            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier
                    .width(100.dp)
            ) {
                quantityList.forEach { value ->
                    DropdownMenuItem(onClick = {
                        selectedText = value
                        ticketsList.add(ticketTypeModel)
                        isExpanded = false
                        val ticket = ticketTypeModel.copy(quantity = selectedText)
                        //update selections
                        viewModel.addTickets(
                            ticketType = ticket,
                            clientDetails = clientDetails
                        )
                    }) {
                        Text(
                            text = value,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
                .constrainAs(divider) {
                    top.linkTo(quantityDropDown.bottom, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                },
            color = Color.LightGray,
            thickness = 1.dp
        )
    }
}