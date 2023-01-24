package cu.desoft.filhabana.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.Datasource
import cu.desoft.filhabana.databinding.FragmentHomeBinding
import cu.desoft.filhabana.ui.activities.MainActivity
import cu.desoft.filhabana.ui.adapters.OptionAdapter
import cu.desoft.filhabana.util.DialogHelper

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myOnBackPressed()
    }

    fun myOnBackPressed() {
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            var cont = 0
            override fun handleOnBackPressed() {
                if (cont == 0) {
                    Snackbar.make(
                        binding.root,
                        resources.getString(R.string.exit_again_toast),
                        Snackbar.LENGTH_SHORT
                    ).show()
                    cont++
                } else {
                    activity!!.finishAffinity()
                }
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {}
                    override fun onFinish() {
                        cont = 0
                    }
                }.start()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

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
        val options_names = resources.getStringArray(R.array.home_options_names)
        val optionsList = Datasource().loadHomeOptions(options_names)
        val optionAdapter = OptionAdapter(optionsList, context)
        binding.recyclerHomeOptions.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerHomeOptions.adapter = optionAdapter
    }

    fun initAppLogo() {
        try {
            if (MainActivity.mainActionBar.logo == null)
                MainActivity.mainActionBar.setLogo(R.mipmap.ic_launcher)
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
                DialogHelper.showExitDialog(activity as Activity)
                true
            }
            R.id.ic_mores -> {
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