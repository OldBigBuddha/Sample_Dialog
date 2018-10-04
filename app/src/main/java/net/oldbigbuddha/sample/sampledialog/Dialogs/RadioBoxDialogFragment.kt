package net.oldbigbuddha.sample.sampledialog.Dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import net.oldbigbuddha.sample.sampledialog.R

class RadioBoxDialogFragment: DialogFragment() {

    lateinit var onSelectedItem: DialogInterface.OnClickListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)
            builder.setTitle("Basic Dialog")
                    .setSingleChoiceItems(R.array.items, 0/* default selected */,onSelectedItem)


            builder.create()
        } ?: throw IllegalAccessError("Activity cannot be null")
    }

}