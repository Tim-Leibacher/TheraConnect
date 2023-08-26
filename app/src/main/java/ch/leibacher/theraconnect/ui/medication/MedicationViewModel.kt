package ch.leibacher.theraconnect.ui.medication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MedicationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is medication Fragment"
    }
    val text: LiveData<String> = _text
}