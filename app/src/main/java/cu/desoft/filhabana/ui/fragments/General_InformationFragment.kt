package cu.desoft.filhabana.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cu.desoft.filhabana.databinding.FragmentGeneralInformationBinding

class General_InformationFragment : Fragment() {

    private lateinit var binding: FragmentGeneralInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGeneralInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

}