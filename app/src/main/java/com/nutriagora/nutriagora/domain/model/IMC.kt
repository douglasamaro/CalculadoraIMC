package com.nutriagora.nutriagora.domain.model

import com.nutriagora.nutriagora.domain.logic.IMCcalculator

class IMC(val peso: Double, val altura: Double) {

    fun CalcularIMC(): Double {
        val imc: Double = IMCcalculator().CalcularIMC(peso, altura)
        return imc
    }

}