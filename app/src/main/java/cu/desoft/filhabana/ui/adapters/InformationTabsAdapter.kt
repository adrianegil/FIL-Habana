package cu.desoft.filhabana.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import cu.desoft.filhabana.ui.fragments.DetailsFragment
import cu.desoft.filhabana.ui.fragments.GuestCountryFragment
import cu.desoft.filhabana.ui.fragments.HonoredAuthorsFragment

class InformationTabsAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return DetailsFragment()
            1 -> return GuestCountryFragment()
            else -> return HonoredAuthorsFragment()
        }
    }
}