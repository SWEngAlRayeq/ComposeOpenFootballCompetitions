package app.open_football_competitions.domain.usecase

import app.open_football_competitions.domain.model.Competition
import app.open_football_competitions.domain.repo.FootballRepository
import javax.inject.Inject

class GetCompetitionsUseCase @Inject constructor(
    private val repository: FootballRepository
) {
    suspend operator fun invoke(): List<Competition> {
        return repository.getCompetitions()
    }
}