package ch.leibacher.theraconnect.ui.medical_problem

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ch.leibacher.theraconnect.databinding.FragmentDashboardBinding
import ch.leibacher.theraconnect.databinding.FragmentMedicalProblemBinding
import ch.leibacher.theraconnect.ui.medication.MedicationViewModel

class MedicalProblemFragment : Fragment() {

    private var _binding: FragmentMedicalProblemBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val medicalProblemView =
            ViewModelProvider(this).get(MedicalProblemViewModel::class.java)

        _binding = FragmentMedicalProblemBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
