package com.example.taller4

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData

class LibroDTO (
    val titulo: String = "N/A",
    val autores: List<String> = emptyList(),
    val edicion: String = "N/A",
    val editorial: String = "N/A",
    val isbn: String = "N/A",
    val sinopsis: String = "N/A",
    val tags: List<String> = emptyList()
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeStringList(autores)
        parcel.writeString(edicion)
        parcel.writeString(editorial)
        parcel.writeString(isbn)
        parcel.writeString(sinopsis)
        parcel.writeStringList(tags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LibroDTO> {
        override fun createFromParcel(parcel: Parcel): LibroDTO {
            return LibroDTO(parcel)
        }

        override fun newArray(size: Int): Array<LibroDTO?> {
            return arrayOfNulls(size)
        }
    }
}