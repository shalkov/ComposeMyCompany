package ru.shalkoff.mycompany.presentation.screens.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.shalkoff.mycompany.R
import ru.shalkoff.mycompany.getMockData
import ru.shalkoff.mycompany.ui.theme.*

@Composable
fun MainScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(color = White_Gray)
    val coroutineScope = rememberCoroutineScope()

    Column(Modifier.background(White_Gray)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painterResource(R.drawable.surf_logo),
                contentDescription = "surf_logo",
                Modifier.padding(20.dp)
            )
            IconButton(
                modifier = Modifier
                    .padding(20.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .align(Alignment.CenterEnd)
                    .size(40.dp),
                onClick = {
                    //Todo
                }
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Информация о приложении",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }
        }
        Procedures(coroutineScope)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Procedures(coroutineScope: CoroutineScope) {
    val nameEmp = "Сотрудники".uppercase()
    val nameProjects = "Проекты".uppercase()
    val aboutApp = "О приложении".uppercase()
    val tabData = listOf(
        nameEmp,
        nameProjects,
        aboutApp
    )

    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    Column {

        // TAB
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            edgePadding = 20.dp,
            backgroundColor = White_Gray,
            contentColor = White_Gray,
            indicator = @Composable { tabPositions ->
                Box(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
                ) {
                    Box(
                        Modifier
                            .width(24.dp)
                            .height(3.dp)
                            .clip(RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp))
                            .background(Blue)
                            .align(Alignment.Center)
                    )
                }
            }
        ) {
            tabData.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }, text = {
                        Text(
                            text = title,
                            color = if (tabIndex == index) {
                                Blue
                            } else {
                                Gray
                            },
                            style = typography().h1
                        )
                    }
                )
            }
        }

        // PAGER
        HorizontalPager(
            count = 3,
            state = pagerState
        ) { index ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.size(8.dp))
                when {
                    tabData[index] == nameEmp -> {
                        Column(
                            modifier = Modifier
                                .verticalScroll(rememberScrollState())
                        ) {
                            getMockData().forEach { employee ->
                                EmployeeItem(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 20.dp, end = 20.dp, top = 16.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .clickable {

                                    },
                                    employee = employee
                                )
                            }
                        }
                    }
                    tabData[index] == nameProjects -> {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(
                                text = "Проекты",
                                Modifier
                                    .padding(16.dp)
                                    .align(Alignment.Center),
                                style = typography().h2
                            )
                        }
                    }
                    tabData[index] == aboutApp -> {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(
                                text = "О приложении",
                                Modifier
                                    .padding(16.dp)
                                    .align(Alignment.Center),
                                style = typography().h2
                            )
                        }
                    }
                }
            }
        }
    }
}
