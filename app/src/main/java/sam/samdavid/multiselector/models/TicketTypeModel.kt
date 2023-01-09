package sam.samdavid.multiselector.models

data class TicketTypeModel(
    val id: String,
    val amount: String,
    var quantity: String = "0",
    val name: String
)

