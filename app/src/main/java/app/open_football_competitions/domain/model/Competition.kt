package app.open_football_competitions.domain.model

data class Competition(
    val id: Int,
    val name: String,
    val country: String,
    val emblem: String?
)