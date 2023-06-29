package com.isit322sp23.bitsandpizzas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isit322sp23.bitsandpizzas.databinding.FragmentOrderBinding
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import android.widget.RadioGroup
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            val pizzaType = binding.pizzaGroup.checkedRadioButtonId
            if (pizzaType == -1) {
                val text = "You need to choose a pizza type"
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            } else {
                var text = (when (pizzaType) {
                    R.id.radio_diavolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                })
                text += if (binding.Parmesan.isChecked) ", extra parmesan" else ""
                text += if (binding.chiliOil.isChecked) ", extra Chili oil" else ""
                Snackbar.make(binding.fab, text, Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}