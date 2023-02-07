package cu.desoft.filhabana.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.model.Stand
import cu.desoft.filhabana.databinding.ItemListParticipantBinding

class StandAdapter(var standsList: List<Stand>, var context: Context?) :
    RecyclerView.Adapter<StandAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemListParticipantBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: ItemListParticipantBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListParticipantBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list_participant,
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.TextViewName.text = standsList.get(position).name
        holder.binding.textViewLocation.text = standsList.get(position).location
        holder.binding.textViewTopics.text =
            "${context?.getString(R.string.topics)}: ${standsList.get(position).topics}"
    }

    override fun getItemCount(): Int {
        return standsList.size
    }
}