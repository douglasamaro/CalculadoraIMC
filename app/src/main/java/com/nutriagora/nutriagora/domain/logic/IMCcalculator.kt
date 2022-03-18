package com.nutriagora.nutriagora.domain.logic

class IMCcalculator {

    fun CalcularIMC(peso: Double, altura: Double): Double {
        val IMC: Double = peso / (altura * altura)
        return IMC
    }

}