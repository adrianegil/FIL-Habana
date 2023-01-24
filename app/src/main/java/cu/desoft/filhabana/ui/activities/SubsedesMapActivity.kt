package cu.desoft.filhabana.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.davemorrissey.labs.subscaleview.ImageSource
import cu.desoft.filhabana.R
import cu.desoft.filhabana.databinding.ActivityMapSubsedesBinding

class SubsedesMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapSubsedesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapSubsedesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        binding.imageViewMap.setImage(ImageSource.resource(R.drawable.map_subsedes))

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}