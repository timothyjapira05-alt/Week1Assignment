package com.timothy.lib2

import kotlin.system.exitProcess

val listMakanan: ArrayList<Menu> = ArrayList<Menu>()
val orderMakanan: ArrayList<Order> = ArrayList<Order>()

fun main(){

    listMakanan.add(Menu("Nasi Goreng", 15000))
    listMakanan.add(Menu("Mie Goreng", 10000))
    listMakanan.add(Menu("Capcay", 20000))

    printMenu()

}
fun printMenu(){
    println("Menu")
    println("1. Make Order")
    println("2. View Orders")
    println("3. View Menu")
    println("4. Add Menu")
    println("5. Edit Menu")
    println("6. Delete Menu")
    println("7. Exit")
    println("Choose: ")
    val choose: String = readlnOrNull()!!

    when(choose){
        "1" -> makeOrder()
        "2" -> viewOrder()
        "3" -> viewMenu()
        "4" -> addMenu()
        "5" -> editMenu()
        "6" -> deleteMenu()
        "7" -> exitProcess(0)
        else -> {
            println("Please choose the following menu")
            printMenu()
        }
    }
    printMenu()

}
fun makeOrder(){
    println("Make Order")
    for(i in 0 until  (listMakanan.size)){
        println("${i+1}) ${listMakanan[i].getNama()} ${listMakanan[i].getHarga()}")
    }
    println("Choose:")
    val choose = readlnOrNull()!!.toInt()
    println("Quantity:")
    val quantity = readlnOrNull()!!.toInt()
    orderMakanan.add(Order(listMakanan[choose-1], quantity))
    println("Order berhasil ditambahkan!")
}
fun viewOrder(){
    println("View Order")
    for(i in 0 until  (orderMakanan.size)){
        println("${i+1}) ${orderMakanan[i].getFood().getNama()} x${orderMakanan[i].getQuantity()} ${orderMakanan[i].getFood().getHarga()*orderMakanan[i].getQuantity()}")
    }
}
fun viewMenu(){
    println("View Menu")
    for(i in 0 until  (listMakanan.size)){
        println("${i+1}) ${listMakanan[i].getNama()} ${listMakanan[i].getHarga()}")
    }
}
fun addMenu(){
    println("Add Menu")
    println("Food Name:")
    val name = readlnOrNull()!!
    println("Food Price:")
    val price = readlnOrNull()!!.toInt()
    listMakanan.add(Menu(name, price))
    println("Menu berhasil ditambahkan!")
}
fun editMenu(){
    viewMenu()
    println("Edit Menu")
    println("Choose:")
    val choose = readlnOrNull()!!.toInt()
    println("Food Name:")
    val name = readlnOrNull()!!
    println("Food Price:")
    val price = readlnOrNull()!!.toInt()
    listMakanan.set(choose-1, Menu(name, price))
}
fun deleteMenu(){
    viewMenu()
    println("Delete Menu")
    println("Choose:")
    val choose = readlnOrNull()!!.toInt()
    listMakanan.removeAt(choose-1)
}
