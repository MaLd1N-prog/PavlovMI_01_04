package com.example.pavlovmi_01_04.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.pavlovmi_01_04.MainActivity
import com.example.pavlovmi_01_04.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            val login = binding.loginEntry.text.toString().trim()
            val password = binding.passwordEntry.text.toString().trim()

            if (login.isEmpty() || password.isEmpty()) {
                AlertDialog.Builder(requireActivity())
                    .setTitle("Ошибка")
                    .setMessage("Введите логин и пароль")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
                return@setOnClickListener
            }
            (activity as? MainActivity)?.openCalculator()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}