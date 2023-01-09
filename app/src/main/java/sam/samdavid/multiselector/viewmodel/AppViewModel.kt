package sam.samdavid.multiselector.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import sam.samdavid.multiselector.models.ClientModel
import sam.samdavid.multiselector.models.SelectedTypeModel
import sam.samdavid.multiselector.models.TicketTypeModel

class AppViewModel: ViewModel() {
    var selectedTicketType by mutableStateOf(SelectedTypeModel())

     var _selectionState = mutableStateOf("")
     val selectionState: State<String> = _selectionState

    private var _ticketsState = mutableStateOf(SelectedTypeModel())
    private val ticketsState: State<SelectedTypeModel> = _ticketsState

    private var _ticketList = mutableListOf<TicketTypeModel>()
    private val ticketList: List<TicketTypeModel> get() = _ticketList
    var _ticketTitle= mutableStateOf("")
    val ticketTitle: State<String> = _ticketTitle
    fun addTickets(ticketType: TicketTypeModel, clientDetails: ClientModel){
        _ticketList.add(ticketType)
        _ticketsState.value = SelectedTypeModel(
            tickets = ticketList,
            details = arrayListOf(clientDetails)
        )
    }

    fun getTickets() = ticketsState
}