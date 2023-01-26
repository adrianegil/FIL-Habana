package cu.desoft.filhabana.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.model.HonoredAuthor
import cu.desoft.filhabana.databinding.ItemListHonoredAuthorsBinding

class HonoredAuthorAdapter(var honoredAuthorsList: List<HonoredAuthor>, var context: Context?) :
    RecyclerView.Adapter<HonoredAuthorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListHonoredAuthorsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list_honored_authors,
            parent, false
        )
        return HonoredAuthorAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val honoredAuthor = honoredAuthorsList.get(position)
        holder.binding.imageView4.setImageResource(honoredAuthor.imageResourceId)
        holder.binding.textViewAuthorName.text = honoredAuthor.stringName
        holder.binding.textViewAuthorDescription.text = honoredAuthor.stringDescription
        holder.binding.layoutExpandedHonoredAuthor.setVisibility(if (honoredAuthor.contentExpandable) View.VISIBLE else View.GONE)
        holder.binding.viewLookAuthorDescription.setOnClickListener {
            honoredAuthor.contentExpandable = !honoredAuthor.contentExpandable
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return honoredAuthorsList.size
    }


    class ViewHolder(binding: ItemListHonoredAuthorsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val binding: ItemListHonoredAuthorsBinding

        init {
            this.binding = binding
        }

    }
}