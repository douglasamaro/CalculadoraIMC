package com.nutriagora.nutriagora.domain.formatt

class FormartterDecimal(){

    fun formartar(numero: Double): String  {
        return String.format("%.2f", numero)
    }

}