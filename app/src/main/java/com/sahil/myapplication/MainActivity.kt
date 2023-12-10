package com.sahil.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val profileList:ArrayList<String> = arrayListOf("Jhon deo","Marin Kanen","Allex dued","Kavin semon","Vikas","Dubbey","pritty","Kolen","Samphil")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    Scaffold(topBar = {TopBar()}) { innerPadding->
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            color= Color.LightGray
        ) {
            ProfileList(profileList)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onSecondary,
        ),
        title = {
            Text("Topic")
        },
        navigationIcon = { IconButton(onClick = { /* do something */ }) {
            Icon(
                imageVector = Icons.Default.Home,
                tint = Color.White,
                contentDescription = "Localized description"
            )
        }}
    )
}

@Composable
fun ProfileList(profileList: ArrayList<String>) {
LazyColumn{
    items(profileList) {profile->
        ProfileCard(profile)
    }
}
}


@Composable
fun ProfileCard(profile: String) {
    Card(modifier= Modifier
        .fillMaxWidth()
        .wrapContentHeight(align = Alignment.Top)
        .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)) {
        Row (modifier = Modifier.wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start){
            ProfilePicture()
            ProfileContent(profile)
        }
    }
}

@Composable
fun ProfileContent(profile: String) {
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Text(text = profile, style = MaterialTheme.typography.headlineSmall)
        Text(text = "Active now",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.alpha(0.5f))
    }

}

@Composable
fun ProfilePicture() {
    Card(shape = CircleShape,
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.profile_1), contentDescription ="Profile image" ,Modifier.size(70.dp))

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}