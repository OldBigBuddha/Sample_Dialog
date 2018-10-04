package net.oldbigbuddha.sample.sampledialog.Dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import net.oldbigbuddha.sample.sampledialog.R

class CheckBoxDialogFragment: DialogFragment() {

    lateinit var onClickPositive: DialogInterface.OnClickListener
    lateinit var onClickNegative: DialogInterface.OnClickListener
    lateinit var onMultiSelected: DialogInterface.OnMultiChoiceClickListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Basic Dialog")
                    .setMultiChoiceItems(R.array.items, null/* default selected */,onMultiSelected)
                    .setPositiveButton("OK", onClickPositive)
                    .setNegativeButton("cancel", onClickNegative)

            builder.create()
        } ?: throw IllegalAccessError("Activity cannot be null")
    }

}