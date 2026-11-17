package com.example.pavlovmi_01_04.utils

object CreditCalculator {

    fun calculateMonthlyPayment(sum: Double, months: Int): Double {
        val base = sum / months

        return when {
            months <= 12 -> {
                (base + sum * 0.059) / 1000.0
            }
            months <= 24 -> {
                val paid12 = base * 12
                val s1 = base + sum * 0.059
                val s2 = base + (sum - paid12) * 0.051
                ((s1 + s2) / 2.0) / 1000.0
            }
            else -> {
                val paidN = base * Math.min(months.toDouble(), 24.0)
                val s1 = base + sum * 0.059
                val s2 = base + (sum - base * 12) * 0.051
                val s3 = base + (sum - paidN) * 0.042
                ((s1 + s2 + s3) / 3.0) / 1000.0
            }
        }
    }
}