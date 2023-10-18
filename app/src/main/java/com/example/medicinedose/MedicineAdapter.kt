package com.example.medicinedose

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedicineAdapter(private val medicines: List<Medicine>, private val onItemClick: (Medicine) -> Unit) :
    RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {

    inner class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val doseTextView: TextView = itemView.findViewById(R.id.doseTextView)
        private val strengthTextView: TextView = itemView.findViewById(R.id.strengthTextView)

        fun bind(medicine: Medicine) {
            nameTextView.text = medicine.name
            doseTextView.text = medicine.dose
            strengthTextView.text = medicine.strength

            itemView.setOnClickListener { onItemClick(medicine) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.medicine_item, parent, false)
        return MedicineViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        holder.bind(medicines[position])
    }

    override fun getItemCount(): Int {
        return medicines.size
    }
}
