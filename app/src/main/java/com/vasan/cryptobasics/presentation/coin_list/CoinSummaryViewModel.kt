package com.vasan.cryptobasics.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vasan.cryptobasics.common.Resource
import com.vasan.cryptobasics.domain.use_case.get_coin_summary.GetCoinSummaryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinSummaryViewModel @Inject constructor(
    private val getCoinSummaryUseCase: GetCoinSummaryUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinSummaryState())
    val state: State<CoinSummaryState> = _state

    init {
        getCoinSummary()
    }

    private fun getCoinSummary(){
        getCoinSummaryUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinSummaryState(coinSummary = result.data?.coins ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinSummaryState(error = result.message ?: "An Unexpected error Occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinSummaryState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}