package ch.leibacher.theraconnect.ui.diagnostics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiagnosticsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is diagnostics Fragment"
    }
    val text: LiveData<String> = _text
}