package net.oldbigbuddha.sample.sampledialog.Dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.util.Log
import net.oldbigbuddha.sample.sampledialog.R

class ListDialogFragment: DialogFragment() {
    lateinit var onSelectedItem: DialogInterface.OnClickListener


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)
            builder.setTitle("List Dialog")
                    .setItems(R.array.items, onSelectedItem)


            builder.create()
        } ?: throw IllegalAccessError("Activity cannot be null")
    }
}