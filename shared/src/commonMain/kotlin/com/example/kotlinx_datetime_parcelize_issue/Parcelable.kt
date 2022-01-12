package com.example.kotlinx_datetime_parcelize_issue

import kotlinx.datetime.LocalDate

@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
public expect annotation class CommonParcelize()

public expect interface CommonParcelable

@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
@Target(AnnotationTarget.CLASS, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
public expect annotation class CommonTypeParceler<T, P : CommonParceler<in T>>()

@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.BINARY)
public expect annotation class CommonRawValue()

public expect interface CommonParceler<T>

public expect object LocalDateParceler : CommonParceler<LocalDate>
