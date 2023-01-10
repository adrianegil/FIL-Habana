package cu.desoft.filhabana.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.Datasource
import cu.desoft.filhabana.databinding.FragmentSubSedeBinding
import cu.desoft.filhabana.ui.adapters.SubSedeAdapter

class SubSedeFragment : Fragment() {

    private lateinit var binding: FragmentSubSedeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubSedeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerSubsede()
    }

    private fun initRecyclerSubsede() {
        val subsede_locationNames = resources.getStringArray(R.array.subsedes_names)
        val subsedeList = Datasource().loadSubsedes(subsede_locationNames)
        val subsedeAdapter = SubSedeAdapter(subsedeList, context)
        binding.recyclerSubsedes.layoutManager = LinearLayoutManager(context)
        binding.recyclerSubsedes.adapter = subsedeAdapter
    }

}