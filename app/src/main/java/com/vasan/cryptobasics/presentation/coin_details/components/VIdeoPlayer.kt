package com.vasan.cryptobasics.presentation.coin_details.components

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


@Composable
fun VideoPlayer(url : String){
    val mContext = LocalContext.current
    val player = YouTubePlayerView(mContext)

    player.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
        override fun onReady(youTubePlayer: YouTubePlayer) {
            //if your url is something like this -> https://www.youtube.com/watch?v=EzyXVfyx7CU
            if (url.contains("https://www.youtube.com")){
                val split = url.split("watch?v=").toTypedArray()
                youTubePlayer.cueVideo(split[1], 0f)
            }
            if (url.contains("https://youtu.be/")){
                val split = url.split(".be/").toTypedArray()
                youTubePlayer.cueVideo(split[1], 0f)
            }
        }
    })

    AndroidView(factory = { context ->
        player
    })

}

// For displaying preview in
// the Android Studio IDE emulator
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VideoPlayer(" ")
}