package com.dxn.pizzae.data.models

data class Size(
    val id: Int,
    val name: String,
    val price: Float
)

val fakeSize1 = Size(
    id = 1,
    name = "Regular",
    price = 235.0f
)

val fakeSize2 = Size(
    id = 2,
    name = "Medium",
    price = 285.0f
)

val fakeSize3 = Size(
    id = 3,
    name = "Large",
    price = 295.0f
)