package com.example.testimage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentView() {

    val pagerState = rememberPagerState()
    
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PagerContent(pagerState = pagerState)
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PagerContent(pagerState: PagerState) {
    
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        pageCount = 2,
        state = pagerState
    ) { pager ->
        when(pager) {
            0 -> {
                MainPage()
            }
            1 -> {
                LazyColumn{
                    items(30){
                        ImageTable()
                    }
                }

            }
        }
    }
}