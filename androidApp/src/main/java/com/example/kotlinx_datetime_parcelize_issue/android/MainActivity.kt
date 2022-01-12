package com.example.kotlinx_datetime_parcelize_issue.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.example.kotlinx_datetime_parcelize_issue.Greeting
import android.widget.TextView
import com.example.kotlinx_datetime_parcelize_issue.Person

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        val person = Person(
            id = "134",
            firstName = "John",
            lastName = "White"
        )

        val personParcelable = person.forceParcel()

        assert(person == personParcelable)
    }
}

inline fun <reified T> T.forceParcel(): T? where T : Parcelable {
    val bytes = Parcel.obtain().use {
        writeParcelable(this@forceParcel, 0)
        marshall()
    }
    return Parcel.obtain().use {
        unmarshall(bytes, 0, bytes.size)
        setDataPosition(0)
        readParcelable(T::class.java.classLoader)
    }
}

inline fun <reified T> Parcel.use(action: Parcel.() -> T): T {
    return try {
        action()
    } finally {
        recycle()
    }
}
