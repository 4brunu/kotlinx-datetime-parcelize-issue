package com.example.kotlinx_datetime_parcelize_issue

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}