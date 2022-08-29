package com._404.cosmos.springpicnic.game.converter

import com._404.cosmos.springpicnic.game.GameStatus
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class GameStatusConverter: AttributeConverter<GameStatus, String> {
    override fun convertToDatabaseColumn(attribute: GameStatus?): String {
        TODO("Not yet implemented")
    }

    override fun convertToEntityAttribute(dbData: String?): GameStatus {
        TODO("Not yet implemented")
    }

}