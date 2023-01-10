package cu.desoft.filhabana.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import cu.desoft.filhabana.R
import cu.desoft.filhabana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myAppBarConfiguration: AppBarConfiguration

    companion object {
        lateinit var navController: NavController
        lateinit var mainActionBar: Toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainActionBar = binding.toolbarMainActivity
        setContentView(binding.root)
        configAppBar()
    }

    //CONFIGURACIÓN DE LA TOOLBAR CON NAVIGATION COMPONENT
    fun configAppBar() {
        setSupportActionBar(mainActionBar)
        mainActionBar.setLogo(R.drawable.ic_log)
        myAppBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_homeFragment,
        )
            .build()
        navController = Navigation.findNavController(this, R.id.host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, myAppBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.host_fragment)
        return (NavigationUI.navigateUp(navController, myAppBarConfiguration)
                || super.onSupportNavigateUp())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mainActionBar.logo != null)
            outState.putBoolean("logoVisible", true)
        else
            outState.putBoolean("logoVisible", false)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean("logoVisible"))
            mainActionBar.setLogo(R.drawable.ic_log)
        else
            mainActionBar.setLogo(null)
    }
}