package com.example.jetpackcomposetasks.task1_lazy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposetasks.ui.theme.Gray
import com.example.jetpackcomposetasks.ui.theme.Gray2
import com.example.jetpackcomposetasks.ui.theme.Pink
import com.example.jetpackcomposetasks.ui.theme.White


@Composable
fun MyScreen() {
    val vm:GymsViewModel = viewModel()
    LazyColumn(
        modifier = Modifier
//LazyColumn did that automatic .verticalScroll(rememberScrollState()) // New << when recomposition occurs it will remember my last position >>
            .fillMaxSize()
            .background(Gray2),
        contentPadding = PaddingValues(8.dp),
    ) {
        items(vm.getGyms()){ item ->
            Item(item)

        }
    }
}
@Composable
fun Item(item:Item) {

    var favoriteState by rememberSaveable { mutableStateOf(false) }
    val icon = if(favoriteState) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder

    Card(
        elevation = CardDefaults.cardElevation(4.dp), // New
        modifier = Modifier.padding(8.dp)
    ) {
        Row (
            modifier = Modifier.background(White),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painterResource(id = item.image),
                contentDescription = "Logo",
                modifier = Modifier.weight(0.15f)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .weight(0.70f)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        color = Pink,
                        fontSize = 28.sp,
                        FontWeight.Bold,
                        fontFamily = FontFamily.Cursive
                    )
                )
                Text(
                    text = item.description,
                    style = TextStyle(
                        color = Gray,
                        fontSize = 14.sp,
                        FontWeight.W400,
                        ),
                    maxLines = 2,
                )
            }
            FavoriteIcon(icon, modifier = Modifier.weight(0.15f)){
                favoriteState = !favoriteState
            }

        }
    }
}
/*
* The state Hoisting is a concept happen when you are changing the compose state from the default state to stateful
* but this change is not UI only it's related to data and we may use it in a viewModel.
* $ So what is the benefit : Unidirectional flow - Reusability we can minimize the code by creating one stateless compose .
*/
@Composable
fun FavoriteIcon(icon: ImageVector, modifier: Modifier, onClick:()-> Unit) {

    Image(
        imageVector = icon,
        contentDescription = "Add to favorite",
        modifier = modifier
            .padding(5.dp)
            .clickable {
                onClick()
            }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewMyScreen() {
    MyScreen()
}

