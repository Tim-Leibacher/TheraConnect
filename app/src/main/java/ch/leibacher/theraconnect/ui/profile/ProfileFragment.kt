package ch.leibacher.theraconnect.ui.profile

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ch.leibacher.theraconnect.R
import ch.leibacher.theraconnect.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*


class ProfileFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private var dateButton: Button? = null
    private var viewModel: ProfileViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val tempDateButton = rootView.findViewById<Button>(R.id.dateButton)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        tempDateButton?.setOnClickListener {
            showDatePicker()
        }

        return rootView
    }


    private fun showDatePicker() {
        val currentDate: Calendar = Calendar.getInstance()
        val sevenDaysLater: Calendar = Calendar.getInstance()
        sevenDaysLater.add(Calendar.DAY_OF_MONTH, 7)
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            dateSetListener,
            currentDate.get(Calendar.YEAR),
            currentDate.get(Calendar.MONTH),
            currentDate.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.minDate = currentDate.timeInMillis
        datePickerDialog.datePicker.maxDate = sevenDaysLater.timeInMillis
        datePickerDialog.show()
    }

    private val dateSetListener =
        OnDateSetListener { view: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
            val selectedDate: Calendar = Calendar.getInstance()
            selectedDate.set(Calendar.YEAR, year)
            selectedDate.set(Calendar.MONTH, month)
            selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            viewModel?.setSelectedDate(selectedDate)
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val formattedDate: String = sdf.format(Date(selectedDate.timeInMillis))
            dateButton?.text = formattedDate
        }
}