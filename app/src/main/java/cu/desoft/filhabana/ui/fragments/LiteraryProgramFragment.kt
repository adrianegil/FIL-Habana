package cu.desoft.filhabana.ui.fragments

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import cu.desoft.filhabana.R
import cu.desoft.filhabana.databinding.FragmentLiteraryProgramBinding
import cu.desoft.filhabana.databinding.FragmentSubSedeBinding

class LiteraryProgramFragment : Fragment() {

    private lateinit var binding: FragmentLiteraryProgramBinding
    private val LITERARY_PROGRAM_URL = "https://www.google.com/"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLiteraryProgramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
    }

}