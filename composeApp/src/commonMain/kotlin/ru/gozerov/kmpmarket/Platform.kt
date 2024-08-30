package ru.gozerov.kmpmarket

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform