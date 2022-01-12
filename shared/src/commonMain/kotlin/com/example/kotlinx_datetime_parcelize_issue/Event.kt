package com.example.kotlinx_datetime_parcelize_issue

import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month

@CommonParcelize
@CommonTypeParceler<LocalDate, LocalDateParceler>()
public data class Event(
    val id: String,
    val name: String,
    val date: @CommonRawValue LocalDate,
): CommonParcelable {
    companion object {
        fun generate() : Event {
            return Event(
                id = "1234678",
                name = "Calendar Event",
                date = LocalDate(2021, Month.JULY, 23)
            )
        }
    }
}
