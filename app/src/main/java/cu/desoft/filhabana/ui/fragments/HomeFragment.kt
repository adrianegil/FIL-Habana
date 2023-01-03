package cu.desoft.filhabana.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import cu.desoft.filhabana.MainActivity
import cu.desoft.filhabana.R
import cu.desoft.filhabana.databinding.FragmentHomeBinding

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