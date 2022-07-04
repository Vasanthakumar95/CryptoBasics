package com.vasan.cryptobasics.presentation.coin_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView


@Composable
fun ExoPlayer(url : String){

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        val mediaItem = MediaItem.fromUri(url)
        val mContext = LocalContext.current
        val mExoPlayer = ExoPlayer.Builder(mContext).build()
        mExoPlayer.addMediaItem(mediaItem)

        AndroidView(factory = { context ->
            StyledPlayerView(context).apply {
                player = mExoPlayer

            }
        })
    }

}

// For displaying preview in
// the Android Studio IDE emulator
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExoPlayer(" ")
}