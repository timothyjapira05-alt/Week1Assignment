package com.timothy.lib

import kotlin.random.Random
var user: User = User("", 50, 30, 0, 5, 5, false, 10, 0, 50, 30)
fun main(){
    println("Insert your name")
    val name = readln()
    println("Hello $name")
    user.setUsername(name)
    mainMenu()
}
fun mainMenu(){
    println("What you're going to do?")
    println("1. View Stats")
    println("2. Enter Battle")
    println("Choose:")
    val choose = readlnOrNull()!!.toInt()
    if (choose == 1){
        viewStats()
    }else if(choose == 2){
        enterBattle()
    }else{
        println("Please choose the following menu!")
        mainMenu()
    }
    mainMenu()
}
fun viewStats(){
    while (true){
        println("---- ${user.getUsername()}'s Stats ----")
        println("HP = ${user.getHp()}/50")
        println("Mana = ${user.getMana()}/30")
        println("Kill needed to evolve = ${user.getKill()}/5")
        println("Health Potions held = ${user.getHealthPotion()}")
        println("Mana Potions held = ${user.getManaPotion()}")
        println("1. Drink Mana Potion")
        println("2. Drink Health Potion")
        println("3. Rename Self")
        println("4. Back")
        println("Choose:")
        val choose = readlnOrNull()!!.toInt()
        if (choose == 1){
            drinkMana()
        }else if(choose == 2){
            drinkHealth()
        }else if (choose == 3){
            rename()
        }else if (choose == 4){
            break
        }

    }

}
fun drinkMana(){
    if (user.getManaPotion()>0){
        if (user.getMana().plus(15) >= user.getMaxMana()){
            user.setMana(user.getMaxMana())
            user.setManaPotion(user.getManaPotion()-1)
        }else{
            user.setMana(user.getMana()+15)
            user.setManaPotion(user.getManaPotion()-1)
        }
    }else{
        println("Mana Potion tidak cukup")
    }
}
fun drinkHealth(){
    if (user.getHealthPotion()>0){
        if (user.getHp().plus(25) >= user.getMaxHp()){
            user.setHp(user.getMaxHp())
            user.setHealthPotion(user.getHealthPotion()-1)
        }else{
            user.setHp(user.getHp()+25)
            user.setHealthPotion(user.getHealthPotion()-1)
        }
    }else{
        println("Health Potion tidak cukup")
    }
}
fun rename(){
    println("Enter Name:")
    val name: String = readlnOrNull()!!
    user.setUsername(name)
    println("Rename Successfull!")
}
fun enterBattle(){
    if (user.getHp() > 0){
        val a = Random.nextInt(1,4)
        val hp = Random.nextInt(30, 51)
        val enemy: Enemy
        var turn: Int = 0
        if (a == 1){
            enemy = Enemy("Grassmon", hp, "Grass")
        }else if (a == 2){
            enemy = Enemy("Firemon", hp, "Fire")
        }else{
            enemy = Enemy("Watermon", hp, "Water")
        }
        while (true) {
            if (turn % 2 == 0) {
                println("--- Battle ---")
                println(user.getUsername())
                println("HP: ${user.getHp()}/50")
                println("Mana: ${user.getMana()}/30")
                println("Health Potions: ${user.getHealthPotion()}")
                println("Mana Potions: ${user.getManaPotion()}")
                println()
                println(enemy.getName())
                println("HP: ${enemy.getHp()}")
                println("Type: ${enemy.getType()}")
                println("----------")
                println("1. Water Attack")
                println("2. Grass Attack")
                println("3. Fire Attack")
                println("4. Drink Potion")
                println("5. Run")
                println("Choose:")
                val choose = readlnOrNull()!!.toInt()
                if (choose == 1 && user.getMana() > 0) {
                    if (enemy.getType() == "Fire") {
                        enemy.setHp(enemy.getHp() - 2 * user.getAtk())
                    } else {
                        enemy.setHp(enemy.getHp() - user.getAtk())
                    }
                    if (user.getIsSuper()){
                        user.setHp(user.getHp()+ user.getKill())
                    }
                    user.setMana(user.getMana()-10)
                } else if (choose == 2&& user.getMana() > 0) {
                    if (enemy.getType() == "Water") {
                        enemy.setHp(enemy.getHp() - 2 * user.getAtk())
                    } else {
                        enemy.setHp(enemy.getHp() - user.getAtk())
                    }
                    if (user.getIsSuper()){
                        user.setHp(user.getHp()+ user.getKill())
                    }
                    user.setMana(user.getMana()-10)
                } else if (choose == 3&& user.getMana() > 0) {
                    if (enemy.getType() == "Grass") {
                        enemy.setHp(enemy.getHp() - 2 * user.getAtk())
                    } else {
                        enemy.setHp(enemy.getHp() - user.getAtk())
                    }
                    if (user.getIsSuper()){
                        user.setHp(user.getHp()+ user.getKill())
                    }
                    user.setMana(user.getMana()-10)
                } else if (choose == 4) {
                    println("Choose Potion")
                    println("1. Health Potion")
                    println("2. Mana Potion")
                    println("Choose:")
                    val choose = readlnOrNull()!!.toInt()
                    if (choose == 1) {
                        drinkHealth()
                    } else if (choose == 2) {
                        drinkMana()
                    }
                } else if (choose == 5) {
                    println("Lah cupu banget kocak")
                    break
                }
                turn++
            } else {
                println("Enemy Attack you!")
                user.setHp(user.getHp() - 10)
                turn++
            }
            if (enemy.getHp() <= 0) {
                println("You win!")
                user.setKill(user.getKill() + 1)
                break
            }
            if (user .getHp()<=0){
                println("You Lose!")
                user.setHp(0)
                break
            }
        }

    }else{
        println("Your HP is 0, you  can't join the battle")
    }
}



