package de.boese.soundbot

import de.boese.soundbot.events.MessageListeningEvent
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent

public fun main() {
    val jda = JDABuilder.createDefault(System.getenv("discordAccessToken"))
    jda.addEventListeners(MessageListeningEvent())
    jda.enableIntents(
        GatewayIntent.GUILD_MESSAGES,
        GatewayIntent.DIRECT_MESSAGES,
        GatewayIntent.GUILD_MEMBERS,
        GatewayIntent.GUILD_PRESENCES,
        GatewayIntent.MESSAGE_CONTENT
    );
    jda.build()
}
