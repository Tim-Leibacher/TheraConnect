package ch.leibacher.theraconnect.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ProfileViewModel : ViewModel() {

    private val selectedDate: MutableLiveData<Calendar> = MutableLiveData<Calendar>()

    fun getSelectedDate(): MutableLiveData<Calendar>? {
        return selectedDate
    }

    fun setSelectedDate(calendar: Calendar) {
        selectedDate.value = calendar
    }
}