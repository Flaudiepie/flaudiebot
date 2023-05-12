package de.boese.soundbot.events

import de.boese.soundbot.sound.dao.implementation.SoundObjectDaoImplementation
import de.boese.soundbot.utils.MessageHelper

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class MessageListeningEvent : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        try {
            val message = event.message.contentRaw
            val args = message.split(" ").drop(1)

            if (message.startsWith("!soundboard") && !args.isEmpty()) {
                when (args[0]) {
                    "upload" -> SoundObjectDaoImplementation.addSound(event.message.attachments, args[1])
                    "play" -> SoundObjectDaoImplementation.getSound(args[1])
                    "remove" -> SoundObjectDaoImplementation.removeSound(args[1])
                    "list" -> MessageHelper.sendMutliLineMessage(
                        event,
                        SoundObjectDaoImplementation.getAllSounds().map { it.name })

                    else -> MessageHelper.sendSingleMessage(event, "Invalid Command")
                }
            }
        } catch (err: Exception) {
            MessageHelper.sendSingleMessage(event, err.message!!)
        }
    }
}