package com._404.cosmos.springpicnic.game.converter

import com._404.cosmos.springpicnic.game.GameStatus
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class GameStatusConverter: AttributeConverter<GameStatus, String> {
    override fun convertToDatabaseColumn(gameStatus: GameStatus): String {
        return gameStatus.status
    }

    override fun convertToEntityAttribute(status: String): GameStatus {
    return GameStatus.valueOf(status.uppercase())
    }

}