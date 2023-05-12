package de.boese.soundbot.sound.dao.implementation

import de.boese.soundbot.sound.dao.SoundObjectDao
import de.boese.soundbot.sound.domain.SoundObject
import net.dv8tion.jda.api.entities.Message.Attachment
import java.io.File
import java.io.InvalidObjectException

object SoundObjectDaoImplementation : SoundObjectDao {
    const val path = "/opt/media/"

    override fun addSound(attachments: List<Attachment>, name: String) {
        val mediaFile = attachments[0]
        if (mediaFile.fileExtension == "mp3" || mediaFile.fileExtension == "wav") {
            mediaFile.proxy.downloadToFile(File("$path$name.${mediaFile.fileExtension}"))
        } else {
            throw InvalidObjectException("File is not mp3 or wav!")
        }
    }

    override fun removeSound(name: String) {
        TODO("Not yet implemented")
    }

    override fun getSound(name: String): SoundObject {
        TODO("Not yet implemented")
    }

    override fun findByUser(username: String): List<SoundObject> {
        TODO("Not yet implemented")
    }

    override fun getAllSounds(): List<SoundObject> {
        val files = File(path).listFiles()
        return files!!.map { SoundObject(it.nameWithoutExtension) }
    }
}