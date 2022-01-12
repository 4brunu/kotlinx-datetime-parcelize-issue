package com.example.kotlinx_datetime_parcelize_issue

import android.os.Parcel
import android.os.Parcelable
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toKotlinLocalDate
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.parcelize.TypeParceler

public actual typealias CommonParcelize = Parcelize

public actual typealias CommonParcelable = Parcelable

public actual typealias CommonRawValue = RawValue

public actual typealias CommonTypeParceler<T, P> = TypeParceler<T, P>

public actual typealias CommonParceler<T> = Parceler<T>

public actual object LocalDateParceler : Parceler<LocalDate> {
    override fun create(parcel: Parcel): LocalDate {
        val javaLocalDate = parcel.readSerializable() as? java.time.LocalDate
            ?: throw RuntimeException("Unable to read java LocalDate")
        val kotlinxLocalDate = javaLocalDate.toKotlinLocalDate()
        return kotlinxLocalDate
    }

    override fun LocalDate.write(parcel: Parcel, flags: Int) {
        val javaLocalDate = this.toJavaLocalDate()
        parcel.writeSerializable(javaLocalDate)
    }
}
