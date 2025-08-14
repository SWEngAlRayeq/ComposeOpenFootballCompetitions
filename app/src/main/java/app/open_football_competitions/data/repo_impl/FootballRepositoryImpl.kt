package app.open_football_competitions.data.repo_impl

import app.open_football_competitions.data.remote.FootballApi
import app.open_football_competitions.domain.model.Competition
import app.open_football_competitions.domain.repo.FootballRepository
import javax.inject.Inject

class FootballRepositoryImpl @Inject constructor(
    private val api: FootballApi
) : FootballRepository {
    override suspend fun getCompetitions(): List<Competition> {
        return api.getCompetitions().competitions.map {
            Competition(
                id = it.id,
                name = it.name,
                country = it.area.name,
                emblem = it.area.flag
            )
        }
    }
}