package com.dxn.pizzae.data.models

data class Response(
    val crusts: List<Crust>,
    val defaultCrust: Int,
    val description: String,
    val id: String,
    val isVeg: Boolean,
    val name: String
)