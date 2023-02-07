package cu.desoft.filhabana.ui.fragments

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cu.desoft.filhabana.data.Datasource
import cu.desoft.filhabana.data.model.Carp
import cu.desoft.filhabana.databinding.FragmentCarpBinding
import cu.desoft.filhabana.ui.adapters.CarpAdapter
import java.util.ArrayList

class CarpFragment : Fragment() {

    private lateinit var binding: FragmentCarpBinding
    private lateinit var carpsList: List<Carp>
    private lateinit var carpsAdapter: CarpAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerCarps()

        val mSearchManager =
            requireContext().getSystemService(Context.SEARCH_SERVICE) as SearchManager

        try {
            binding.searchCarp.setSearchableInfo(
                mSearchManager.getSearchableInfo(
                    ComponentName(
                        requireContext(),
                        javaClass
                    )
                )
            )
        } catch (e: Exception) {
            Log.d("searchStand", "EXCE " + e.message)
        }

        binding.searchCarp.setOnSearchClickListener(View.OnClickListener { v: View? ->
            binding.searchCarp.setImeOptions(
                EditorInfo.IME_ACTION_SEARCH
            )
        })
        binding.searchCarp.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(arg0: String): Boolean {
                Log.d("searchStand", "text submit $arg0")
                return true
            }

            override fun onQueryTextChange(arg0: String): Boolean {
                Log.d("searchStand", "text change $arg0")
                val filteredCapList: MutableList<Carp> = ArrayList()
                if (arg0 == null || arg0.length == 0) {
                    filteredCapList.addAll(carpsList)
                } else {
                    val filterPattern = arg0.toLowerCase().trim { it <= ' ' }
                    for (item in carpsList) {
                        if (item.name.toLowerCase().contains(filterPattern)) {
                            filteredCapList.add(item)
                        }
                    }
                }
                carpsAdapter = CarpAdapter(filteredCapList, context)
                binding.recyclerCarp.adapter = carpsAdapter
                return true
            }
        })

        binding.searchCarp.setIconifiedByDefault(false)
        binding.searchCarp.isActivated = true

        binding.searchCarp.setOnCloseListener(SearchView.OnCloseListener {
            carpsAdapter = CarpAdapter(carpsList, context)
            false
        })
    }

    private fun initRecyclerCarps() {
        carpsList = Datasource().loadCarps()
        carpsAdapter = CarpAdapter(carpsList, context)
        binding.recyclerCarp.layoutManager = LinearLayoutManager(context)
        binding.recyclerCarp.adapter = carpsAdapter
    }

}