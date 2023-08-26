package ch.leibacher.theraconnect.ui.diagnostics

import DiagnosisAdapter
import DiagnosisItem
import android.R
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
            DiagnosisItem("Cancer", listOf("xy", "ab"), null),
            DiagnosisItem("Flu", listOf("ab"), "Fever")
            // Add more items as needed
        )

        adapter = DiagnosisAdapter(itemList)
        recyclerView.adapter = adapter

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}