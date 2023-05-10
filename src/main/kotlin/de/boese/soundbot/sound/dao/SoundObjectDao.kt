package de.boese.soundbot.sound.dao

import de.boese.soundbot.sound.domain.SoundObject
import net.dv8tion.jda.api.entities.Message.Attachment

public interface SoundObjectDao {
    fun addSound(attachments: List<Attachment>, name: String)
    fun removeSound(name: String)
    fun getSound(name: String): SoundObject
    fun findByUser(username: String): List<SoundObject>
    fun getAllSounds(): List<SoundObject>
}