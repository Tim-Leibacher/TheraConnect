package ch.leibacher.theraconnect.ui.diagnostics

import DiagnosisAdapter
import DiagnosisDetailFragment
import DiagnosisItem
import android.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.leibacher.theraconnect.databinding.FragmentDashboardBinding
import ch.leibacher.theraconnect.databinding.FragmentDiagnoseBinding
import ch.leibacher.theraconnect.ui.medical_problem.MedicalProblemViewModel
import ch.leibacher.theraconnect.MainActivity





class DiagnosticsFragment : Fragment() {

    private var _binding: FragmentDiagnoseBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DiagnosisAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val diagnosticsViewModel =
            ViewModelProvider(this).get(DiagnosticsViewModel::class.java)

        _binding = FragmentDiagnoseBinding.inflate(inflater, container, false)
        val rootView = binding.root
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val dividerItemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        val itemList = listOf(
            DiagnosisItem("Allergy", listOf("Antihistamines", "Decongestants", "Epinephrine"),
                "Antihistamines help relieve allergy symptoms, decongestants reduce nasal congestion, and epinephrine treats severe allergic reactions."),
            DiagnosisItem("Flu", listOf("Antiviral medication", "Pain relievers", "Cough syrup"),
                "The antiviral medication helps to fight the flu virus, pain relievers reduce discomfort, and cough syrup helps suppress coughing."),
            DiagnosisItem(
                "Hypertension",
                listOf("ACE inhibitors", "Beta blockers", "Diuretics"),
                "ACE inhibitors help relax blood vessels, beta blockers reduce heart rate, and diuretics help lower blood pressure by increasing urine output."
            ),
            DiagnosisItem(
                "Diabetes",
                listOf("Insulin", "Metformin", "SGLT2 inhibitors"),
                "Insulin helps regulate blood sugar levels, metformin improves insulin sensitivity, and SGLT2 inhibitors reduce blood sugar reabsorption by the kidneys."
            ),
            DiagnosisItem(
                "Depression",
                listOf("SSRIs", "SNRIs", "Tricyclic antidepressants"),
                "SSRIs increase serotonin levels in the brain, SNRIs enhance serotonin and norepinephrine, and tricyclic antidepressants affect neurotransmitter balance."
            )
        )

        adapter = DiagnosisAdapter(itemList) { clickedItem ->
            // Handle item click here, for example, open detail popup fragment
            showDialog(clickedItem)
        }
        recyclerView.adapter = adapter

        return rootView
    }

    fun showDialog(clickedItem: DiagnosisItem) {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("Diagnose: " + clickedItem.diagnose + "\nMedication:\n"
            + clickedItem.medicaments.joinToString("\n") + "\nReason for this medication: "
            + (clickedItem.reason ?: "No reason provided")
        )
        dialogBuilder.setTitle("Medication detail")
        dialogBuilder.setPositiveButton("Done",
            DialogInterface.OnClickListener { dialog, whichButton -> })
        val b = dialogBuilder.create()
        b.show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}