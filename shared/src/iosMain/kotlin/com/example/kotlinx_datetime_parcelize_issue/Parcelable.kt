package com.example.kotlinx_datetime_parcelize_issue

import kotlinx.datetime.LocalDate

public actual interface CommonParcelable

public actual interface CommonParceler<T>

public actual object LocalDateParceler : CommonParceler<LocalDate>
