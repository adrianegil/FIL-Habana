package cu.desoft.filhabana.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import cu.desoft.filhabana.MainApplication
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.Datasource
import cu.desoft.filhabana.databinding.FragmentHonoredAuthorsBinding
import cu.desoft.filhabana.ui.adapters.HonoredAuthorAdapter

class HonoredAuthorsFragment : Fragment() {

    private lateinit var binding: FragmentHonoredAuthorsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHonoredAuthorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerHonoredAuthors()
    }

    private fun initRecyclerHonoredAuthors() {
        val honoredAuthorsNames = resources.getStringArray(R.array.honored_authors_names)
        val honoredAuthorsList = Datasource().loadHonoredAuthors(honoredAuthorsNames, context)
        val honoredAuthorsAdapter = HonoredAuthorAdapter(honoredAuthorsList, context)
        binding.recycleHonoredAuthors.layoutManager = LinearLayoutManager(context)
        binding.recycleHonoredAuthors.adapter = honoredAuthorsAdapter
    }
}