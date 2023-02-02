package cu.desoft.filhabana.util

import android.app.Activity
import cu.desoft.filhabana.R
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

class DialogHelper {

    companion object {

        fun showExitDialog(activity: Activity) {
            val dialog = AlertDialog.Builder(activity)
            dialog.setTitle(R.string.exit_confirm)
            dialog.setMessage(R.string.exit_confirm_description)
            dialog.setPositiveButton(R.string.yes) { dialog12: DialogInterface?, which: Int -> activity.finishAffinity() }
            dialog.setNegativeButton("No") { dialog13: DialogInterface, which: Int -> dialog13.dismiss() }
            dialog.setNeutralButton(R.string.cancel) { dialog1: DialogInterface, which: Int -> dialog1.dismiss() }
            dialog.show()
        }

        fun showLiteraryProgramDialog(activity: Activity) {
            val dialog = AlertDialog.Builder(activity)
            dialog.setTitle(activity.getString(R.string.important_info))
            dialog.setMessage(R.string.literary_program_info)
            dialog.setPositiveButton("Ok") { dialog12: DialogInterface, which: Int -> dialog12.dismiss() }
            dialog.setNeutralButton(R.string.cancel) { dialog1: DialogInterface, which: Int -> dialog1.dismiss() }
            dialog.show()
        }
    }

}