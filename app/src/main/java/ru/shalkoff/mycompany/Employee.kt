package ru.shalkoff.mycompany

import androidx.compose.ui.graphics.Color
import ru.shalkoff.mycompany.ui.theme.*

data class Employee(
    val icon: Int,
    val name: String,
    val position: String,
    val type1: String,
    val type2: String,
    val colorText: Color,
    val colorBackground: Color
)

fun getMockData(): List<Employee> {
    return listOf(
        Employee(
            R.drawable.face_one,
            "Ольга Кудрявцева",
            "Аналитик-стажёр",
            "Маркетинг",
            "Начало карьеры",
            Blue,
            Blue_Transparent
        ),
        Employee(
            R.drawable.face_two,
            "Игорь Крутой",
            "IOS Разработчик",
            "Разработка",
            "Swift",
            Orange,
            Orange_Transparent
        ),
        Employee(
            R.drawable.face_tree,
            "Алеся Патрикеевна",
            "UX/UI Дизайнер",
            "Дизайн",
            "Figma",
            Green,
            Green_Transparent
        ),
        Employee(
            R.drawable.face_one,
            "Ольга Кудрявцева",
            "Аналитик-стажёр",
            "Маркетинг",
            "Начало карьеры",
            Blue,
            Blue_Transparent
        ),
        Employee(
            R.drawable.face_two,
            "Игорь Крутой",
            "IOS Разработчик",
            "Разработка",
            "Swift",
            Orange,
            Orange_Transparent
        ),
        Employee(
            R.drawable.face_tree,
            "Алеся Патрикеевна",
            "UX/UI Дизайнер",
            "Дизайн",
            "Figma",
            Green,
            Green_Transparent
        )
    )
}