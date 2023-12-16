package com.app.recipeapp.pojo.network

import android.os.Parcel
import android.os.Parcelable

data class Recipe(
    val uri: String?,
    val label: String?,
    val image: String?,
    val images: Images?,
    val source: String?,
    val url: String?,
    val shareAs: String?,
    val yield: Int?,
    val dietLabels: List<String>?,
    val healthLabels: List<String>?,
    val cautions: List<String>?,
    val ingredientLines: List<String>?,
    val ingredients: List<Ingredient>?
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Images::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.createTypedArrayList(Ingredient)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uri)
        parcel.writeString(label)
        parcel.writeString(image)
        parcel.writeParcelable(images, flags)
        parcel.writeString(source)
        parcel.writeString(url)
        parcel.writeString(shareAs)
        parcel.writeValue(yield)
        parcel.writeStringList(dietLabels)
        parcel.writeStringList(healthLabels)
        parcel.writeStringList(cautions)
        parcel.writeStringList(ingredientLines)
        parcel.writeTypedList(ingredients)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }

}