package sam.samdavid.multiselector.models

data class SelectedTypeModel(
    val quantity: String = "0",
    var tickets: List<TicketTypeModel> = mutableListOf<TicketTypeModel>(),
    val details: List<ClientModel> = emptyList()
)

