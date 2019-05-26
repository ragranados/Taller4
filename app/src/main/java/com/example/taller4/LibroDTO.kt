package com.example.taller4

import android.nfc.Tag
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData
import com.example.taller4.Entities.Autor
import com.example.taller4.Entities.Tags

class LibroDTO (
        val titulo: String = "N/A",
        val autores: List<Autor>? =ArrayList(),
        val edicion: String = "N/A",
        val isbn: String = "N/A",
        val sinopsis: String = "N/A",
        val tags: List<Tags>? = ArrayList()
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.createTypedArrayList(Autor),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(Tags)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeTypedList(autores)
        parcel.writeString(edicion)
        parcel.writeString(isbn)
        parcel.writeString(sinopsis)
        parcel.writeTypedList(tags)
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