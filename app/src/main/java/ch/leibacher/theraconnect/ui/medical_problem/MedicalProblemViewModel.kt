package ch.leibacher.theraconnect.ui.medical_problem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MedicalProblemViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is medical problem Fragment"
    }
    val text: LiveData<String> = _text


}

