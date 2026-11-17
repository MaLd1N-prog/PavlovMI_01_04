package com.example.pavlovmi_01_04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.pavlovmi_01_04.fragments.CalculatorFragment
import com.example.pavlovmi_01_04.fragments.LoginFragment
import com.example.pavlovmi_01_04.fragments.ResultFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val container = androidx.fragment.app.FragmentContainerView(this).apply {
            id = R.id.fragment_container
        }
        setContentView(container)

        if (savedInstanceState == null) {
            loadFragment(LoginFragment(), false)
        }
    }

    fun openCalculator() {
        loadFragment(CalculatorFragment(), true)
    }

    fun openResult(sum: Double, months: Int) {
        loadFragment(ResultFragment.newInstance(sum, months), true)
    }

    fun goToMainMenu() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    private fun loadFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
        if (addToBackStack) transaction.addToBackStack(null)
        transaction.commit()
    }
}