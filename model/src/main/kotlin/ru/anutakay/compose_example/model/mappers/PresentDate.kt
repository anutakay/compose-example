package ru.anutakay.compose_example.model.mappers

import java.time.LocalDate
import java.time.LocalDateTime

fun presentDate(date: LocalDate) = "${date.dayOfMonth} ${date.month} ${date.year}"
fun presentTime(dateTime: LocalDateTime) = "${dateTime.hour}:${dateTime.minute}"
