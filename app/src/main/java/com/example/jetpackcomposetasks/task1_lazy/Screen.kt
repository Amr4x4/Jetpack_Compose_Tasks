package com.example.jetpackcomposetasks.task1_lazy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetasks.ui.theme.Gray
import com.example.jetpackcomposetasks.ui.theme.Gray2
import com.example.jetpackcomposetasks.ui.theme.Pink
import com.example.jetpackcomposetasks.ui.theme.White


@Composable
fun MyScreen(items: List<Item>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items){ item ->
            Item(item)

        }
    }
}
@Composable
fun Item(item:Item) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
    ) {
        Row (
            modifier = Modifier.background(White)
        ){
            Image(
                painterResource(id = item.image),
                contentDescription = "Logo",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(20.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
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

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewMyScreen() {
    MyScreen(items = itemList())
}

