fun main() {
    var time = 7100
    if (time >= 0) {
        println("Был(а) ${agoToText(time)}") //Выводим значение функции agoToText
    } else {
        println("ОШИБКА!!! Время не может быть отрицательным!!!") //Защитились от отризательных значений переменной time
    }
}

fun agoToText(time: Int): String {
    val string = when (time) { //значение положим в переменную
        in 0..60 -> "только что"
        in 61..60 * 60 -> "${time / 60} минут${minutesEnding(time)} назад" //просим от функции minutesEnding вернуть окончание
        in 60 * 60 + 1..24 * 60 * 60 -> "${time / (60 * 60)} чаc${hoursEnding(time)} назад"
        in 24 * 60 * 60 + 1..48 * 60 * 60 -> "вчера"
        in 48 * 60 * 60 + 1..78 * 60 * 60 -> "позавчера"
        else -> {
            "давно"
        }
    }
    return string //возвращаем значение переменной
}

fun minutesEnding(time: Int): String {
    val endMinutes = when (time / 60) {
        1, 21, 31, 41, 51 -> "у"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "ы"
        else -> ""
    }
    return endMinutes
}

fun hoursEnding(time: Int): String {
    val endHours = when (time / 3600) {
        2, 3, 4, 22, 23 -> "а"
        in 5..20 -> "ов"
        else -> ""
    }
    return endHours
}