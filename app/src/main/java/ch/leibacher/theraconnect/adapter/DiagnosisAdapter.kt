import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.leibacher.theraconnect.R

class DiagnosisAdapter(private val itemList: List<DiagnosisItem>) : RecyclerView.Adapter<DiagnosisAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textDiagnose: TextView = itemView.findViewById(R.id.textDiagnose)
        val textMedicament: TextView = itemView.findViewById(R.id.textMedicament)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_diagnosis, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.textDiagnose.text = item.diagnose
        if (item.medicaments.isNotEmpty()){
            holder.textMedicament.text = item.medicaments.joinToString(", ")
        } else {
            holder.textMedicament.text = "No medication"
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
