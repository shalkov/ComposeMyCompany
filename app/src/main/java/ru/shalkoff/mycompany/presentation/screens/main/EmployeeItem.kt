package ru.shalkoff.mycompany.presentation.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.shalkoff.mycompany.Employee
import ru.shalkoff.mycompany.R
import ru.shalkoff.mycompany.ui.theme.*
import ru.shalkoff.mycompany.ui.theme.Blue_Transparent

@Composable
fun EmployeeItem(
    modifier: Modifier = Modifier,
    elevation: Dp = 2.dp,
    employee: Employee
) {
    Card(
        modifier = modifier,
        elevation = elevation
    ) {
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = employee.name,
                Modifier.padding(16.dp),
                style = typography().h2
            )
            Row(
                Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(employee.icon),
                    contentDescription = "face_one",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(34.dp)
                        .clip(CircleShape)
                )
                Column(Modifier.fillMaxWidth()) {
                    Text(
                        text = employee.position,
                        Modifier.padding(bottom = 8.dp),
                        color = Color.Black
                    )
                    Row(Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier
                                .background(
                                    color = employee.colorBackground,
                                    shape = RoundedCornerShape(50)
                                )
                                .padding(start = 8.dp, end = 8.dp, top = 1.dp, bottom = 2.dp),
                            fontSize = 14.sp,
                            text = employee.type1,
                            color = employee.colorText
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier
                                .background(
                                    color = Gray_Transparent,
                                    shape = RoundedCornerShape(50)
                                )
                                .padding(start = 8.dp, end = 8.dp, top = 1.dp, bottom = 2.dp),
                            fontSize = 14.sp,
                            text = employee.type2,
                            color = Gray
                        )
                    }
                }
            }
        }
    }
}