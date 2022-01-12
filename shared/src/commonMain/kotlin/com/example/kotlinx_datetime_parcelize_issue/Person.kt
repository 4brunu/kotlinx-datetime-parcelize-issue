package com.example.kotlinx_datetime_parcelize_issue

@CommonParcelize
public data class Person(
    val id: String,
    val firstName: String,
    val lastName: String,
): CommonParcelable
