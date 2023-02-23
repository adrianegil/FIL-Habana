package cu.desoft.filhabana.ui.fragments

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.view.*
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import cu.desoft.filhabana.R
import cu.desoft.filhabana.databinding.FragmentLiteraryProgramBinding
import cu.desoft.filhabana.util.DialogHelper

class LiteraryProgramFragment : Fragment() {

    private lateinit var binding: FragmentLiteraryProgramBinding
    private val LITERARY_PROGRAM_URL = "https://www.filhcuba.cu/"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiteraryProgramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding.refreshLayout.setOnRefreshListener {
            binding.webViewLiteraryProgram.reload()
        }
        binding.webViewLiteraryProgram.webChromeClient = object : WebChromeClient() {

        }
        binding.webViewLiteraryProgram.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.refreshLayout.isRefreshing = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.refreshLayout.isRefreshing = false
            }
        }
        binding.webViewLiteraryProgram.settings.javaScriptEnabled = true
        binding.webViewLiteraryProgram.loadUrl(LITERARY_PROGRAM_URL)
        DialogHelper.showLiteraryProgramDialog(requireActivity())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.literary_program_info, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.ic_literary_program_info -> {
                DialogHelper.showLiteraryProgramDialog(requireActivity())
                true
            }
            else -> {
                super.onOptionsItemSelected(item) || NavigationUI.onNavDestinationSelected(
                    item,
                    Navigation.findNavController(activity as Activity, R.id.host_fragment)
                )
            }
        }
    }

}