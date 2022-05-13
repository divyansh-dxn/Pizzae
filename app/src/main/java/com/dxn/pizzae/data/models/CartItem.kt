package com.dxn.pizzae.data.models

data class CartItem(
    val name: String,
    var count: Int,
    val priceEach: Float,
    val desc: String,
    val isVeg: Boolean
) {
    val id get() = "$name$desc$isVeg"
    override fun equals(other: Any?): Boolean {
        (other as CartItem)
        return name == other.name && isVeg == other.isVeg && desc == other.desc
    }
}