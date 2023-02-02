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
import cu.desoft.filhabana.databinding.FragmentChildProgramBinding
import cu.desoft.filhabana.databinding.FragmentLiteraryProgramBinding

class ChildProgramFragment : Fragment() {

    private lateinit var binding: FragmentChildProgramBinding
    private val CHILD_PROGRAM_URL = "https://www.filhcuba.cu/sala-dora-alonso"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChildProgramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.refreshLayout.setOnRefreshListener {
            binding.webViewChildProgram.reload()
        }
        binding.webViewChildProgram.webChromeClient = object : WebChromeClient() {

        }
        binding.webViewChildProgram.webViewClient = object : WebViewClient() {

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
        binding.webViewChildProgram.settings.javaScriptEnabled = true
        binding.webViewChildProgram.loadUrl(CHILD_PROGRAM_URL)
    }
}