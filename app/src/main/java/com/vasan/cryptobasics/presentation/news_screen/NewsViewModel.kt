package com.vasan.cryptobasics.presentation.news_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vasan.cryptobasics.common.Resource
import com.vasan.cryptobasics.domain.use_case.get_news.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel(){

    private val _state = mutableStateOf(NewsState())
    val state: State<NewsState> = _state

    init {
        getNews()
    }

    private fun getNews(){
        getNewsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = NewsState(news = result.data?.news ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = NewsState(error = result.message ?: "An Unexpected error Occurred")
                }
                is Resource.Loading -> {
                    _state.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}