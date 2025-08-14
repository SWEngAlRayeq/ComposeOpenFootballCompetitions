package app.open_football_competitions.domain.repo

import app.open_football_competitions.domain.model.Competition

interface FootballRepository {
    suspend fun getCompetitions(): List<Competition>
}