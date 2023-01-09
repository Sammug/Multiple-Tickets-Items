package sam.samdavid.multiselector.models

data class SelectedTypeModel(
    var tickets: List<TicketTypeModel> = mutableListOf<TicketTypeModel>(),
    val details: List<ClientModel> = emptyList()
)

