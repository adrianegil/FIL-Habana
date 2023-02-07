package cu.desoft.filhabana.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.ArrayList

class ParticipantAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(
    fm!!
) {
    private val fragments: MutableList<Fragment> = ArrayList()
    private val fragmentsTitle: MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        fragmentsTitle.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentsTitle[position]
    }
}