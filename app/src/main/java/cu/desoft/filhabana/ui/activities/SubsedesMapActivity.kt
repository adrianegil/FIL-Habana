package cu.desoft.filhabana.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import cu.desoft.filhabana.R
import cu.desoft.filhabana.databinding.ActivityMapSubsedesBinding
import java.lang.Exception

class SubsedesMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapSubsedesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapSubsedesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        loadImage()

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun loadImage() {
        binding.imageViewMap.setImage(ImageSource.resource(R.drawable.map_subsedes))
        binding.imageViewMap.setOnImageEventListener(object :
            SubsamplingScaleImageView.OnImageEventListener {
            override fun onReady() {
                binding.progressBar.visibility = View.INVISIBLE
            }

            override fun onImageLoaded() {
                binding.progressBar.visibility = View.INVISIBLE
            }

            override fun onPreviewLoadError(e: Exception?) {
                TODO("Not yet implemented")
            }

            override fun onImageLoadError(e: Exception?) {
                TODO("Not yet implemented")
            }

            override fun onTileLoadError(e: Exception?) {
                TODO("Not yet implemented")
            }

            override fun onPreviewReleased() {
                TODO("Not yet implemented")
            }

        })
    }
}