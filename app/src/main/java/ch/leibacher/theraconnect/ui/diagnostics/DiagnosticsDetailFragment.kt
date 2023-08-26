import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ch.leibacher.theraconnect.R
import ch.leibacher.theraconnect.databinding.FragmentDashboardBinding

class DiagnosisDetailFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        private const val ARG_DIAGNOSIS_ITEM = "arg_diagnosis_item"

        fun newInstance(diagnosisItem: DiagnosisItem): DiagnosisDetailFragment {
            val fragment = DiagnosisDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_DIAGNOSIS_ITEM, diagnosisItem)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = binding.root

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        val textView: TextView = binding.textDashboard

        return textView
    }
}