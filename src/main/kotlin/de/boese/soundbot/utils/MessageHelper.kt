package de.boese.soundbot.utils

import net.dv8tion.jda.api.events.message.MessageReceivedEvent

object MessageHelper {
    fun sendSingleMessage(event: MessageReceivedEvent, content: String) {
        event.channel.sendMessage(content).queue()
    }

    fun sendMutliLineMessage(event: MessageReceivedEvent, content: List<String>){
        event.channel.sendMessage(content.joinToString(separator = "\n")).queue()
    }
}