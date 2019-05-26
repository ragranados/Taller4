package com.example.taller4.Entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Autor")
data class Autor (
    val nombre: String
):Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id:Long=0

    constructor(parcel: Parcel) : this(parcel.readString()) {
        id = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeLong(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Autor> {
        override fun createFromParcel(parcel: Parcel): Autor {
            return Autor(parcel)
        }

        override fun newArray(size: Int): Array<Autor?> {
            return arrayOfNulls(size)
        }
    }
}