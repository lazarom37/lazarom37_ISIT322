package com.isit322sp23.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isit322sp23.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {
    ArticleCard(
        title = stringResource(R.string.title),
        shortDescription = stringResource(R.string.shortDesc),
        longDescription = stringResource(R.string.longDesc),
        image = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    image: Painter
    ) {
    Column{
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth())
        Text(text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp,)
        );
        Text(text = shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp,)
        );
        Text(text = longDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        );
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        //img()
        ComposeArticleApp()
        //Body(filler1);
        //Body(filler2)
    }
}