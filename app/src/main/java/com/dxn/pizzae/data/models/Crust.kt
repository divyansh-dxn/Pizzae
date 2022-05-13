package com.dxn.pizzae.data.models

data class Crust(
    val defaultSize: Int,
    val id: Int,
    val name: String,
    val sizes: List<Size>
)

val fakeCrust1 = Crust(
    defaultSize = 2,
    id = 1,
    name = "Hand Tossed",
    sizes = listOf(fakeSize1, fakeSize2, fakeSize3)
)

val fakeCrust2 = Crust(
    defaultSize = 1,
    id = 2,
    name = "Cheese-burst",
    sizes = listOf(fakeSize3, fakeSize4)
)