package net.oldbigbuddha.sample.sampledialog

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*
import net.oldbigbuddha.sample.sampledialog.Dialogs.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_basic.setOnClickListener {
            BasicDialogFragment().show(supportFragmentManager, "basic")
        }

        bt_button.setOnClickListener {
            val fragment = ButtonDialogFragment()
            fragment.onClickPositive = DialogInterface.OnClickListener { _, _ ->
                Snackbar.make(container, "OnClick 'OK'", Snackbar.LENGTH_SHORT).show()
            }
            fragment.onClickNegative = DialogInterface.OnClickListener {_, _ ->
                Snackbar.make(container, "OnClick 'cancel'", Snackbar.LENGTH_SHORT).show()
            }
            fragment.show(supportFragmentManager, "button")
        }

        bt_list.setOnClickListener {
            val fragment = ListDialogFragment()
            Log.i("OnClicked", "List Dialog")
            fragment.onSelectedItem = DialogInterface.OnClickListener {_, index ->
                resources?.let {
                    val item = it.getStringArray(R.array.items)[index]
                    Snackbar.make(container, "Selected $item", Snackbar.LENGTH_SHORT).show()
                }
            }
            fragment.show(supportFragmentManager, "list")
        }

        bt_check.setOnClickListener {
            val fragment = CheckBoxDialogFragment()
            val mSelectedItems = ArrayList<Int>() // Where we track the selected items

            fragment.onMultiSelected = DialogInterface.OnMultiChoiceClickListener { _, index, isChecked ->
                if (isChecked) {
                    mSelectedItems.add(index)
                } else if (mSelectedItems.contains(index)) {
                    mSelectedItems.remove( Integer.valueOf(index) )
                }
            }
            fragment.onClickPositive = DialogInterface.OnClickListener { _, _ ->

                resources?.apply {
                    val mSelectedItemContents = ArrayList<String>()
                    mSelectedItems.forEach {
                        mSelectedItemContents.add(this.getStringArray(R.array.items)[it])
                    }

                    Snackbar.make(container, "Selected $mSelectedItemContents", Snackbar.LENGTH_SHORT).show()

                }
            }
            fragment.onClickNegative = DialogInterface.OnClickListener {_, _ ->
                Snackbar.make(container, "OnClick 'cancel'", Snackbar.LENGTH_SHORT).show()
            }
            fragment.show(supportFragmentManager, "checkbox")
        }

        bt_radio.setOnClickListener {
            val fragment = RadioBoxDialogFragment()
            fragment.onSelectedItem = DialogInterface.OnClickListener { _, index ->
                resources?.let {
                    fragment.selectedIndex = index
                }
            }

            fragment.onClickPositive = DialogInterface.OnClickListener{ _, _ ->
                resources?.let {
                    val item = it.getStringArray(R.array.items)[fragment.selectedIndex]
                    Snackbar.make(container, "Selected $item", Snackbar.LENGTH_SHORT).show()
                }
            }
            fragment.show(supportFragmentManager, "radio")
        }

    }
}
