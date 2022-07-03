package com.vasan.cryptobasics.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vasan.cryptobasics.common.Constants
import com.vasan.cryptobasics.common.Resource
import com.vasan.cryptobasics.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let { conId ->
            getCoin(conId)
        }
    }

    private fun getCoin(coinId: String){
        getCoinUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailsState(error = result.message ?: "An Unexpected error Occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}