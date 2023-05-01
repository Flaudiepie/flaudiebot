package de.boese.soundbot.utils

import net.dv8tion.jda.api.events.message.MessageReceivedEvent

object MessageHelper {
    fun sendMessage(event: MessageReceivedEvent, content: String) {
        event.channel.sendMessage(content).queue()
    }
}