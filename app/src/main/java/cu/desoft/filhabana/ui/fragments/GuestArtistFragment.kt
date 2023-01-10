package cu.desoft.filhabana.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.Datasource
import cu.desoft.filhabana.databinding.FragmentGuestArtistBinding
import cu.desoft.filhabana.ui.adapters.GuestArtistAdapter

class GuestArtistFragment : Fragment() {

    private lateinit var binding: FragmentGuestArtistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGuestArtistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerGuestArtists()
    }

    private fun initRecyclerGuestArtists() {
        val guestArtistsNames = resources.getStringArray(R.array.guest_artist_names)
        val guestArtistsList = Datasource().loadGuestArtists(guestArtistsNames)
        val guestArtistAdapter = GuestArtistAdapter(guestArtistsList, context)
        binding.recycleGuestArtists.layoutManager = LinearLayoutManager(context)
        binding.recycleGuestArtists.adapter = guestArtistAdapter
    }
}