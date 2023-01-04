package cu.desoft.filhabana.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.model.HomeOption
import cu.desoft.filhabana.databinding.OptionItemListBinding

class OptionAdapter(var optionsList: List<HomeOption>, var context: Context?) :
    RecyclerView.Adapter<OptionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: OptionItemListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.option_item_list,
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewOptionTitle.text = optionsList.get(position).stringName
        holder.binding.imageViewOption.setImageResource(optionsList.get(position).imageResourceId)
    }

    override fun getItemCount(): Int {
        return optionsList.size
    }

    class ViewHolder(binding: OptionItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: OptionItemListBinding

        init {
            this.binding = binding
        }
    }

}