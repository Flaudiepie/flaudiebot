package de.boese.soundbot

import net.dv8tion.jda.api.JDABuilder

public fun main() {
    val jda = JDABuilder.createDefault(System.getenv("discordAccessToken")).build()
}
