package com.vasan.cryptobasics.presentation.web_view

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.vasan.cryptobasics.common.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WebViewViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _state = mutableStateOf(WebUrlState())
    val state: State<WebUrlState> = _state

    init {
        savedStateHandle.get<String>(Constants.URL_LINK)?.let { link ->
            getUrlLink(link)
        }
    }

    private fun getUrlLink(webLink: String){
        if(webLink != ""){
            _state.value = WebUrlState(webLink = webLink)
        }
        if (webLink == ""){
            _state.value = WebUrlState(error = "Url Not Found")
        }
    }
}