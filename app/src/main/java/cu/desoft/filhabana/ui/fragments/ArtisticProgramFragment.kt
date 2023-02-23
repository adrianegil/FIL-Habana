package cu.desoft.filhabana.ui.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import cu.desoft.filhabana.databinding.FragmentArtisticProgramBinding

class ArtisticProgramFragment : Fragment() {

    private lateinit var binding: FragmentArtisticProgramBinding
    private val ARTISTIC_PROGRAM_URL = "https://www.filhcuba.cu/programa-artistico-cultural"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtisticProgramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.refreshLayout.setOnRefreshListener {
            binding.webViewArtisticProgram.reload()
        }
        binding.webViewArtisticProgram.webChromeClient = object : WebChromeClient() {

        }
        binding.webViewArtisticProgram.webViewClient = object : WebViewClient() {

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
        binding.webViewArtisticProgram.settings.javaScriptEnabled = true
        binding.webViewArtisticProgram.loadUrl(ARTISTIC_PROGRAM_URL)
    }

}