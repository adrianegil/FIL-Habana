package cu.desoft.filhabana.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.model.GuestArtist
import cu.desoft.filhabana.databinding.ItemListGuestArtistBinding

class GuestArtistAdapter(var guestArtistsList: List<GuestArtist>, var context: Context?) :
    RecyclerView.Adapter<GuestArtistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: ItemListGuestArtistBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list_guest_artist,
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewGuestArtist.text = guestArtistsList.get(position).stringName
        holder.binding.imageGuestArtists.setImageResource(guestArtistsList.get(position).imageResourceId)
    }

    override fun getItemCount(): Int {
        return guestArtistsList.size
    }

    class ViewHolder(binding: ItemListGuestArtistBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: ItemListGuestArtistBinding = binding
    }
}