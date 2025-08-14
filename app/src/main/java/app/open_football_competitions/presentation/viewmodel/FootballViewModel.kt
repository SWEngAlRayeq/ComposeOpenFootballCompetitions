package app.open_football_competitions.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.open_football_competitions.domain.model.Competition
import app.open_football_competitions.domain.usecase.GetCompetitionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FootballViewModel @Inject constructor(
    private val getCompetitionsUseCase: GetCompetitionsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<List<Competition>>(emptyList())
    val state: StateFlow<List<Competition>> = _state

    init {
        fetchCompetitions()
    }

    fun fetchCompetitions() {
        viewModelScope.launch {
            _state.value = getCompetitionsUseCase()
        }
    }

}