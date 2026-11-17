package com.example.pavlovmi_01_04.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pavlovmi_01_04.MainActivity
import com.example.pavlovmi_01_04.databinding.FragmentResultBinding
import com.example.pavlovmi_01_04.utils.CreditCalculator
import java.util.Locale

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_SUM = "sum"
        private const val ARG_MONTHS = "months"

        fun newInstance(sum: Double, months: Int): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle().apply {
                putDouble(ARG_SUM, sum)
                putInt(ARG_MONTHS, months)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sum = arguments?.getDouble(ARG_SUM) ?: 0.0
        val months = arguments?.getInt(ARG_MONTHS) ?: 0
        val payment = CreditCalculator.calculateMonthlyPayment(sum, months)

        binding.tvAmountResult.text = String.format(Locale.getDefault(), "Сумма кредита: %,.0f ₽", sum).replace(',', ' ')
        binding.tvTermResult.text = "Срок кредита: $months мес."
        binding.tvPaymentResult.text = String.format(Locale.getDefault(), "Ежемесячный\nплатёж: %.2f тыс. ₽", payment)

        binding.btnToMainMenu.setOnClickListener {
            (activity as? MainActivity)?.goToMainMenu()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}