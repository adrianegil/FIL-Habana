package cu.desoft.filhabana.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.model.Carp
import cu.desoft.filhabana.databinding.ItemListParticipantBinding

class CarpAdapter(var carpsList: List<Carp>, var context: Context?) :
    RecyclerView.Adapter<CarpAdapter.ViewHolder>() {

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

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.TextViewName.text = carpsList.get(position).name
        holder.binding.textViewLocation.text = carpsList.get(position).location
        holder.binding.textViewTopics.text =
            "${context?.getString(R.string.topics)}: ${carpsList.get(position).topics}"
    }

    override fun getItemCount(): Int {
        return carpsList.size
    }
}