package sam.samdavid.multiselector.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import sam.samdavid.multiselector.models.SelectedTypeModel

class AppViewModel: ViewModel() {
    var selectedTicketType by mutableStateOf(SelectedTypeModel())
}