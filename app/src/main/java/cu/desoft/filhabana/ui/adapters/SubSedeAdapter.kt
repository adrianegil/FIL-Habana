package cu.desoft.filhabana.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.model.Subsede
import cu.desoft.filhabana.databinding.ItemListSubsedeBinding

class SubSedeAdapter(var subsedesList: List<Subsede>, var context: Context?) :
    RecyclerView.Adapter<SubSedeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListSubsedeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list_subsede,
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewSubsedeLocation.text = subsedesList.get(position).stringLocation
        holder.binding.imageViewSubsede.setImageResource(subsedesList.get(position).imageResourceId)
    }

    override fun getItemCount(): Int {
        return subsedesList.size
    }


    class ViewHolder(binding: ItemListSubsedeBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: ItemListSubsedeBinding

        init {
            this.binding = binding
        }
    }
}