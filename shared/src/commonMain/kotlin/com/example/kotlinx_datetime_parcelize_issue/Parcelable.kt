package com.example.kotlinx_datetime_parcelize_issue

@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
public expect annotation class CommonParcelize()

public expect interface CommonParcelable
