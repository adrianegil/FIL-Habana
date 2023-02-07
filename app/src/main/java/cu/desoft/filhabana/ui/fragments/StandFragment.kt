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
import cu.desoft.filhabana.data.model.Stand
import cu.desoft.filhabana.databinding.FragmentStandBinding
import cu.desoft.filhabana.ui.adapters.StandAdapter

class StandFragment : Fragment() {

    private lateinit var binding: FragmentStandBinding
    private lateinit var standList: List<Stand>
    private lateinit var standAdapter: StandAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStandBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerStands()

        val mSearchManager =
            requireContext().getSystemService(Context.SEARCH_SERVICE) as SearchManager

        try {
            binding.searchStand.setSearchableInfo(
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

        binding.searchStand.setOnSearchClickListener(View.OnClickListener { v: View? ->
            binding.searchStand.setImeOptions(
                EditorInfo.IME_ACTION_SEARCH
            )
        })
        binding.searchStand.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(arg0: String): Boolean {
                Log.d("searchStand", "text submit $arg0")
                return true
            }

            override fun onQueryTextChange(arg0: String): Boolean {
                Log.d("searchStand", "text change $arg0")
                val filteredStandList: MutableList<Stand> = ArrayList()
                if (arg0 == null || arg0.length == 0) {
                    filteredStandList.addAll(standList)
                } else {
                    val filterPattern = arg0.toLowerCase().trim { it <= ' ' }
                    for (item in standList) {
                        if (item.name.toLowerCase().contains(filterPattern)) {
                            filteredStandList.add(item)
                        }
                    }
                }
                standAdapter = StandAdapter(filteredStandList, context)
                binding.recyclerStand.adapter = standAdapter
                return true
            }
        })

        binding.searchStand.setIconifiedByDefault(false)
        binding.searchStand.isActivated = true

        binding.searchStand.setOnCloseListener(SearchView.OnCloseListener {
            standAdapter = StandAdapter(standList, context)
            false
        })
    }

    private fun initRecyclerStands() {
        standList = Datasource().loadStands()
        standAdapter = StandAdapter(standList, context)
        standAdapter.setHasStableIds(true)
        binding.recyclerStand.layoutManager = LinearLayoutManager(context)
        binding.recyclerStand.adapter = standAdapter
    }
}