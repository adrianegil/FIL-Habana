package cu.desoft.filhabana.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import cu.desoft.filhabana.databinding.FragmentGeneralInformationBinding
import cu.desoft.filhabana.ui.adapters.InformationTabsAdapter

class InformationFragment : Fragment() {

    private lateinit var binding: FragmentGeneralInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGeneralInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.generalInformationViewPager.adapter =
            InformationTabsAdapter(requireActivity().supportFragmentManager, lifecycle)

        binding.generalInformationViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tabLayoutGeneralInformation.selectTab(
                    binding.tabLayoutGeneralInformation.getTabAt(
                        position
                    )
                )
            }
        })

        binding.tabLayoutGeneralInformation.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.generalInformationViewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }

}