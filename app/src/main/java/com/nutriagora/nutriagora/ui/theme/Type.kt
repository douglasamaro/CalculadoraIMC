package com.nutriagora.nutriagora.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.nutriagora.nutriagora.*

val fonts = FontFamily(
    Font(R.font.montserrat_thin , weight = FontWeight.Thin),
    Font(R.font.montserrat_light , weight = FontWeight.Light),
    Font(R.font.montserrat_medium , weight = FontWeight.Medium),
    Font(R.font.montserrat_bold , weight = FontWeight.Bold),
    Font(R.font.montserrat_extrabold , weight = FontWeight.ExtraBold)
)

// Set of Material typography styles to start with
val typography = Typography(
    body1 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Medium,
    fontSize = 13.sp
    ),

    h1 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 25.sp,
    textAlign = TextAlign.Center
),

    h2 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 19.sp
),
    h3 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Light,
        fontSize = 43.sp,
        textAlign = TextAlign.Center
    ),

    h4 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        textAlign = TextAlign.Center
    )


)
