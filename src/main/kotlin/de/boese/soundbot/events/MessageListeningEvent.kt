package de.boese.soundbot.events

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class MessageListener : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val message = event.message.contentRaw
        val args = message.split(" ").drop(1)

        if (message.startsWith("!soundboard") && !args.isEmpty()) {
            val returnedMessage = when (args[0]) {
                "upload" -> "upload"
                "play" -> "not implemented"
                "remove" -> "not implemented"
                else -> "fuck u"
            }
            event.channel.sendMessage(returnedMessage).queue()
        }
    }
}