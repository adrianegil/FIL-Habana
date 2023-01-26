package cu.desoft.filhabana.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.davemorrissey.labs.subscaleview.ImageSource
import cu.desoft.filhabana.R
import cu.desoft.filhabana.databinding.ActivityPrincipalMapBinding

class PrincipalMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrincipalMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        binding.imageViewMap.setImage(ImageSource.resource(R.drawable.map_principal))
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}