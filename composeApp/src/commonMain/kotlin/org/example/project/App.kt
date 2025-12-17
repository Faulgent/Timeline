package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberOverscrollEffect
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val timeline = Timeline(Date(1, 1, 10000, EraDesignator.BCE), Date(1, 1, 2020))
        val timePeriods = listOf(
            Period(startDate = timeline.startDate, endDate = timeline.endDate),
            Period(startDate = timeline.startDate, endDate = timeline.endDate),
            Period(startDate = timeline.startDate, endDate = timeline.endDate),
            Period(startDate = timeline.startDate, endDate = timeline.endDate),
        )
        Box(
            modifier = Modifier.fillMaxSize().padding(horizontal = 50.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column {
                LazyRow(
                    modifier = Modifier.fillMaxWidth().height(25.dp),
                    state = rememberLazyListState(0),
                    reverseLayout = false,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    flingBehavior = ScrollableDefaults.flingBehavior(),
                    userScrollEnabled = true,
                    overscrollEffect = rememberOverscrollEffect(),
                ) {
                    items(items = timePeriods, itemContent = {
                        Spacer(
                            modifier = Modifier.height(10.dp).width(5.dp).background(Color.Black)
                        )
                    })
                }
                Spacer(modifier = Modifier.fillMaxWidth().height(5.dp).background(Color.Black))
            }
        }
        /*var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }*/
    }
}