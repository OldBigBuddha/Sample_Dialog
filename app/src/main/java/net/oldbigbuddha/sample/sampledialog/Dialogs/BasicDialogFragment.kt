package net.oldbigbuddha.sample.sampledialog.Dialogs


import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog


class BasicDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)
            builder.setTitle("Basic Dialog")
                    .setMessage("This is Basic Alert Dialog")


            builder.create()
        } ?: throw IllegalAccessError("Activity cannot be null")
    }
}
