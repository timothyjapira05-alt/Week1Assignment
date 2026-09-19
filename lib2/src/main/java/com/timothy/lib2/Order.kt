package com.timothy.lib2

class Order (
    private val food: Menu,
    private var quantity: Int
){
    fun getFood(): Menu = food
    fun getQuantity(): Int = quantity
    fun setQuantity(value: Int) { quantity = value }
}