package com.vasan.cryptobasics.presentation.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vasan.cryptobasics.presentation.contact.component.Loader
import com.vasan.cryptobasics.presentation.ui.theme.DarkGray
import com.vasan.cryptobasics.presentation.ui.theme.MediumGray
import com.vasan.cryptobasics.presentation.ui.theme.TextWhite

@Composable
fun ContactScreen(
    navController: NavController
){
    Column(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(DarkGray, MediumGray),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                )
            )
            .fillMaxSize().verticalScroll(rememberScrollState())

    ) {

        Card(
            modifier = Modifier.wrapContentHeight(Alignment.CenterVertically),
            elevation = 4.dp,
            backgroundColor = Color.Transparent,
            shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp)
        ){
            Column(modifier = Modifier
                .wrapContentHeight()
                .background(DarkGray)
                .padding(10.dp)
            ) {

                Text(
                    text = "CONTACT",
                    color = TextWhite,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)) {
                    Loader()
                }

            }
        }

        Column(modifier = Modifier
            .wrapContentHeight()
            .background(Color.Transparent)
            .padding(15.dp)
        ) {

            Text(
                text = "Name",
                color = TextWhite,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .align(Alignment.Start)
            )

            Text(
                text = "Vasanthakumar",
                color = TextWhite,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .align(Alignment.Start)
            )

        }

        Divider(
            color = MediumGray,
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 15.dp, end = 15.dp)
        )

        Column(modifier = Modifier
            .wrapContentHeight()
            .background(Color.Transparent)
            .padding(15.dp)
        ) {

            Text(
                text = "Email",
                color = TextWhite,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .align(Alignment.Start)
            )

            Text(
                text = "vasantrajamanickam@gmail.com",
                color = TextWhite,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .align(Alignment.Start)
            )

        }

        Divider(
            color = MediumGray,
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 15.dp, end = 15.dp)
        )

        Column(modifier = Modifier
            .wrapContentHeight()
            .background(Color.Transparent)
            .padding(15.dp)
        ) {

            Text(
                text = "Website",
                color = TextWhite,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .align(Alignment.Start)
            )

            Text(
                text = "vasan.dev",
                color = TextWhite,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .align(Alignment.Start)
            )

        }

        Divider(
            color = MediumGray,
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 15.dp, end = 15.dp)
        )

        Column(modifier = Modifier
            .wrapContentHeight()
            .background(Color.Transparent)
            .padding(15.dp)
        ) {

            Text(
                text = "Phone",
                color = TextWhite,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .align(Alignment.Start)
            )

            Text(
                text = "6011411851",
                color = TextWhite,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .align(Alignment.Start)
            )

        }
    }
}