package cu.desoft.filhabana.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import cu.desoft.filhabana.R
import cu.desoft.filhabana.databinding.FragmentParticipantsBinding
import cu.desoft.filhabana.ui.adapters.ParticipantAdapter

class ParticipantsFragment : Fragment() {

    private lateinit var binding: FragmentParticipantsBinding
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentParticipantsBinding.inflate(inflater, container, false)
        if (savedInstanceState == null) {
            viewPager = binding.viewPagerParticipants
            configViewPager(viewPager)
            binding.tabLayoutParticipants!!.setupWithViewPager(viewPager)
            //  binding.tabLayoutParticipants!!.getTabAt(0)?.setIcon(R.drawable.ic_back)
            //  binding.tabLayoutParticipants!!.getTabAt(1)?.setIcon(R.drawable.ic_book)
        }
        return binding.root
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        viewPager = binding.viewPagerParticipants
        configViewPager(viewPager)
        binding.tabLayoutParticipants!!.setupWithViewPager(viewPager)
        // binding.tabLayoutParticipants!!.getTabAt(0)?.setIcon(R.drawable.ic_back)
        // binding.tabLayoutParticipants!!.getTabAt(1)?.setIcon(R.drawable.ic_book)
    }

    private fun configViewPager(viewPager: ViewPager) {
        val adapter = ParticipantAdapter(childFragmentManager)
        adapter.addFragment(StandFragment(), getString(R.string.stands))
        adapter.addFragment(CarpFragment(), getString(R.string.carps))
        viewPager.adapter = adapter
    }

}