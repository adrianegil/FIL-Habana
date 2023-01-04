package cu.desoft.filhabana.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cu.desoft.filhabana.MainActivity
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.Datasource
import cu.desoft.filhabana.databinding.FragmentHomeBinding
import cu.desoft.filhabana.ui.adapters.OptionAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        initAppLogo()
        initRecyclerOptions()
    }

    private fun initRecyclerOptions() {
        val options_names = resources.getStringArray(R.array.guest_artist_names)
        val optionsList = Datasource().loadHomeOptions(options_names)
        val optionsRecyclerView: RecyclerView = binding.recyclerHomeOptions
        val optionAdapter = OptionAdapter(optionsList, context)
        optionsRecyclerView.layoutManager = GridLayoutManager(context, 2)
        optionsRecyclerView.adapter = optionAdapter
    }

    fun initAppLogo() {
        try {
            if (MainActivity.mainActionBar.logo == null)
                MainActivity.mainActionBar.setLogo(R.drawable.ic_log)
        } catch (e: Exception) {
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_Exit -> {
                activity?.finish()
                true
            }
            else -> {
                MainActivity.mainActionBar.setLogo(null)
                super.onOptionsItemSelected(item) || NavigationUI.onNavDestinationSelected(
                    item,
                    Navigation.findNavController(activity as Activity, R.id.host_fragment)
                )
            }
        }
    }

}