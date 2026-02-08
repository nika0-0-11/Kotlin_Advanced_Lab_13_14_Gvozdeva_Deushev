# Лабораторная работа №13-14

Коллекции, обобщения и функциональный стиль в Kotlin

## Описание

Данная лабораторная работа посвящена изучению продвинутых возможностей языкаKotlin,которые активно используются при разработке Android-приложений.
В рамках работы рассматриваются:
- обобщённые типы (Generics);
- коллекции Kotlin;
- функции высшего порядка;
- extension-функции;
  Все примеры ориентированы на практическое применение и подготовку к разработкемобильных приложений.

---

## Как запустить проект

1. Клонируйте репозиторий:
```bash
git clone <URL_репозитория>
```
2. Откройте проект в IntelliJ IDEA
3. Запустите нужный файл

---

## Примеры изученных тем

### Обобщенные классы (Generics)

```kotlin
data class Question<T> (
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}
```

---

### Коллекции

```kotlin
val planets = listOf("Mercury", "Venus", "Earth", "Mars")
val solarSystem = mutableSetOf("Mercury", "Venus", "Earth")
val moons = mapOf("Earth" to 1, "Mars" to 2)
```

---

### Функции высшего порядка

```kotlin
fun action (n1: Int, n2: Int, op: (Int, Int) -> Int) {
  val result = op(n1, n2)
  println(result)
}

action(5,3, ::sum)
```

---

### Extension-функции
```kotlin
fun Quiz.StudentProgress.printProgressBar() {
    repeat(answered) { print("▓") }
    repeat(total - answered) { print("▒") }
    println()
}
```

---

### Scope-функции

```kotlin
quiz.apply {
    printQuiz()
    printProgressBar()
}
```

---

### Data class и Enum class

```kotlin
data class Book(val title: String, val author: String, val year: Int)
enum class Status { AVAILABLE, BORROWED}
```

---

### Интерфейсы

```kotlin
interface ProgressPrintBar { 
    val progressText: String
    fun printProgressBar()
}
```

---

### Функции для коллекций (map, filter, groupBy, fold, sortedBy)

```kotlin
val prices = cookies.map { it.price }
val softCookies = cookies.filter { it.softBaked }
val grouped = cookies.groupBy { it.softBaked }
val total = cookies.fold(0.0) { total, cookie -> total + cookie.price }
val sorted = cookies.sortedBy { it.name }
```

---


## Автор

**Гвоздева В.А, Деушев Т.Т**

---

## Лицензия

`Проект создан в учебных целях.`