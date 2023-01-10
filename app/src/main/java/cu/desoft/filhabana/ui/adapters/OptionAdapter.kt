package cu.desoft.filhabana.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cu.desoft.filhabana.ui.activities.MainActivity
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.model.HomeOption
import cu.desoft.filhabana.databinding.ItemListOptionBinding

class OptionAdapter(var optionsList: List<HomeOption>, var context: Context?) :
    RecyclerView.Adapter<OptionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListOptionBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list_option,
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewOptionTitle.text = optionsList.get(position).stringName
        holder.binding.imageViewOption.setImageResource(optionsList.get(position).imageResourceId)
        holder.binding.cardViewOption.setOnClickListener {
            when (position) {
                0 -> {
                    MainActivity.navController.navigate(R.id.go_general_InformationFragment)
                    MainActivity.mainActionBar.setLogo(null)
                }
                2 -> {
                    MainActivity.navController.navigate(R.id.go_subSedeFragment)
                    MainActivity.mainActionBar.setLogo(null)
                }
                4 -> {
                    MainActivity.navController.navigate(R.id.go_guestArtistFragment)
                    MainActivity.mainActionBar.setLogo(null)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return optionsList.size
    }

    class ViewHolder(binding: ItemListOptionBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: ItemListOptionBinding

        init {
            this.binding = binding
        }
    }

}