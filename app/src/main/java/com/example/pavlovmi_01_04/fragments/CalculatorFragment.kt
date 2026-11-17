package com.example.pavlovmi_01_04.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pavlovmi_01_04.MainActivity
import com.example.pavlovmi_01_04.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {
    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!
    private val minSum = 30000

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            (activity as? MainActivity)?.goToMainMenu()
        }

        binding.calculateButton.setOnClickListener {
            val termStr = binding.termEntry.text.toString().trim()
            val months = termStr.toIntOrNull()

            if (months == null || months <= 0) {
                Toast.makeText(context, "Введите корректный срок", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sum = (minSum + binding.amountSlider.progress).toDouble()
            (activity as? MainActivity)?.openResult(sum, months)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}