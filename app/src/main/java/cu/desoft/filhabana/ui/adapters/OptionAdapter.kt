package cu.desoft.filhabana.ui.adapters

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.model.HomeOption
import cu.desoft.filhabana.databinding.ItemListOptionBinding
import cu.desoft.filhabana.ui.activities.MainActivity
import cu.desoft.filhabana.ui.activities.PrincipalMapActivity
import cu.desoft.filhabana.ui.activities.SedesMapActivity
import cu.desoft.filhabana.ui.activities.SubsedesMapActivity


class OptionAdapter(var optionsList: List<HomeOption>, var context: Activity?) :
    RecyclerView.Adapter<OptionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListOptionBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list_option,
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewOptionTitle.text = optionsList.get(position).stringName
        holder.binding.imageViewOption.setImageResource(optionsList.get(position).imageResourceId)
        holder.binding.optionItem.setOnClickListener {
            when (position) {
                0 -> {
                    MainActivity.navController.navigate(R.id.go_general_InformationFragment)
                    MainActivity.mainActionBar.setLogo(null)
                }
                1 -> {
                    selectMap()
                }
                2 -> {
                    context?.startActivity(Intent(context, SubsedesMapActivity::class.java))
                }
                4 -> {
                    MainActivity.navController.navigate(R.id.go_guestArtistFragment)
                    MainActivity.mainActionBar.setLogo(null)
                }
                5 -> {
                    MainActivity.navController.navigate(R.id.go_literaryProgramFragment)
                    MainActivity.mainActionBar.setLogo(null)
                }
                6 -> {
                    MainActivity.navController.navigate(R.id.go_artisticProgramFragment)
                    MainActivity.mainActionBar.setLogo(null)
                }
                7 -> {
                    MainActivity.navController.navigate(R.id.go_childProgramFragment)
                    MainActivity.mainActionBar.setLogo(null)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return optionsList.size
    }

    fun selectMap() {

        val view: View = context!!.layoutInflater.inflate(R.layout.maps_options, null)
        val builder: AlertDialog.Builder = AlertDialog.Builder(context!!)
        builder.setView(view)
        builder.setTitle(context?.getString(R.string.select_map))

        val btnPrincipalMap: Button = view.findViewById(R.id.btnPrincipalMap) as Button
        val btnSedesMap: Button = view.findViewById(R.id.btnSedesMap) as Button

        btnPrincipalMap.setOnClickListener {
            context?.startActivity(Intent(context, PrincipalMapActivity::class.java))
        }
        btnSedesMap.setOnClickListener {
            context?.startActivity(Intent(context, SedesMapActivity::class.java))
        }
        builder.setNeutralButton(R.string.cancel) { dialog1: DialogInterface, which: Int ->
            run { dialog1.dismiss() }
        }
        builder.show()
    }

    class ViewHolder(binding: ItemListOptionBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: ItemListOptionBinding

        init {
            this.binding = binding
        }
    }

}