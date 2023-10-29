package com.example.small_instalation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.small_instalation.ui.theme.Small_InstalationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Small_InstalationTheme {
                InstantiationWall()
            }
        }
    }
}

@Composable
fun InstantiationWall(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(1) }

    val imageRes = when (result) {
        1 -> R.drawable.one
        2 -> R.drawable.two
        3 -> R.drawable.three
        4 -> R.drawable.four
        5 -> R.drawable.five
        6 -> R.drawable.six
        7 -> R.drawable.seven
        8 -> R.drawable.eight
        9 -> R.drawable.nine
        else -> R.drawable.ten
    }

    val nameRes = when (result) {
        1 -> "«Геркулес и Минерва, изгоняющие Марса»"
        2 -> "«Аллегория зрения и обоняния»"
        3 -> "«Прерванная работа»"
        4 -> "«Четыре части света»"
        5 -> "«Триумф нептуна»"
        6 -> "«Винтерхальтер»"
        7 -> "«Аллегория слуха»"
        8 -> "«Вакханалия»"
        9 -> "«Битва греков с амазонками»"
        else -> "«Триумф Венеры»"
    }

    val authorRes = when (result) {
        1 -> "Питер Рубенс"
        2 -> "Ян Брейгель"
        3 -> "Вильям Бурго"
        4 -> "Питер Пауль"
        5 -> "Николя Пуссен"
        6 -> "Франц Ксавер"
        7 -> "Питер Рубенс"
        8 -> "Верне Клод-Жозеф"
        9 -> "Ян Брейгель"
        else -> "Франсуа Буше"
    }

    val yearRes = when (result) {
        1 -> "(1630 – 1635)"
        2 -> "(1618)"
        3 -> "(1825-1905)"
        4 -> "(1610)"
        5 -> "(1635-1636)"
        6 -> "(1635)"
        7 -> "(1625)"
        8 -> "(1714-1789)"
        9 -> "(1601-1678)"
        else -> "(1740)"
    }

    Surface(color = colorResource(id = R.color.Bone)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(18.dp)
                .background(colorResource(R.color.Bone))
        ) {

            Box(
                modifier = modifier
                    .weight(9f)
                    .background(colorResource(R.color.white))
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = null,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(30.dp)
                        .background(colorResource(R.color.white))
                )
            }

            Spacer(modifier = modifier.padding(40.dp))

            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .background(colorResource(id = R.color.Yellow_Mandarin))

            ) {
                Column(
                    modifier = modifier.padding(20.dp)
                ) {
                    Text(
                        text = nameRes,
                        fontSize = 30.sp,
                        fontStyle = FontStyle.Normal
                    )
                    Row(horizontalArrangement = Arrangement.Center, modifier = modifier) {
                        Text(
                            text = authorRes,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = yearRes,
                            fontSize = 15.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }

            Spacer(modifier = modifier.padding(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        when (result) {
                            1 -> result = 10
                            in 2..10 -> result -= 1
                        }
                    },
                    modifier = Modifier.size(width = 150.dp, height = 45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = stringResource(R.string.previous),
                        fontSize = 15.sp
                    )
                }
                Button(
                    onClick = {
                        when (result) {
                            in 1..9 -> result += 1
                            10 -> result = 1
                        }
                    },
                    modifier = Modifier.size(width = 150.dp, height = 45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = stringResource(R.string.next),
                        fontSize = 15.sp,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Small_InstalationTheme {
        InstantiationWall()
    }
}