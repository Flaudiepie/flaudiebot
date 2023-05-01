package de.boese.soundbot.sound.dao.implementation

import de.boese.soundbot.sound.dao.SoundObjectDao
import de.boese.soundbot.sound.domain.SoundObject
import net.dv8tion.jda.api.entities.Message.Attachment

public object SoundObjectDaoImplementation : SoundObjectDao {
    override fun addSound(attachments: List<Attachment>, name: String) {
        TODO("Not yet implemented")
    }

    override fun removeSound(name: String) {
        TODO("Not yet implemented")
    }

    override fun selectSound(name: String): SoundObject {
        TODO("Not yet implemented")
    }

    override fun findByUser(username: String): List<SoundObject> {
        TODO("Not yet implemented")
    }
}