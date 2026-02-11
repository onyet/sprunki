package id.onyet.games.sprunki.model

import java.io.Serializable

data class Game(
    val name: String,
    val link: String,
    val thumbnail: String,
    val orientation: String
) : Serializable {
    
    fun isLandscape(): Boolean {
        return orientation.lowercase() == "landscape"
    }
}
