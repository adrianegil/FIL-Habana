package cu.desoft.filhabana.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cu.desoft.filhabana.BuildConfig
import cu.desoft.filhabana.R
import cu.desoft.filhabana.databinding.FragmentAboutBinding
import cu.desoft.filhabana.ui.activities.MainActivity

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewAppVersion.text = "Versión: ${BuildConfig.VERSION_NAME}"

        binding.btnDescription.setOnClickListener {
            MainActivity.navController.navigate(R.id.go_descriptionFragment)
        }

        //binding.textFILHabanaSiteWeb.setPaintFlags(binding.textFILHabanaSiteWeb.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

        binding.textFILHabanaSiteWeb.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.filhcuba.cu/"))
            startActivity(browserIntent)
        }
    }

}