package ru.vafeen

fun String.getSudoCommand() =
    println("sudo ${this.substringAfter("sudo ")}")

fun String.getUserCommand() = println(this)

fun String.printComment() = println("#$this")
