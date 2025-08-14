package app.open_football_competitions.data.model

data class CompetitionsResponseDto(
    val competitions: List<CompetitionDto>
)

data class CompetitionDto(
    val id: Int,
    val area: AreaDto,
    val name: String,
    val emblemUrl: String
)

data class AreaDto(
    val name: String,
    val flag: String,
)