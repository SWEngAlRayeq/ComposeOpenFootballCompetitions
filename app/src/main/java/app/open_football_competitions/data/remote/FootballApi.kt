package app.open_football_competitions.data.remote

import app.open_football_competitions.data.model.CompetitionsResponseDto
import retrofit2.http.GET

interface FootballApi {

    @GET("competitions")
    suspend fun getCompetitions(): CompetitionsResponseDto

}