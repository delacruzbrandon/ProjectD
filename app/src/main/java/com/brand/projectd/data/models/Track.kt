package com.brand.projectd.data.models

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brand.projectd.util.Constants.DATABASE_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = DATABASE_TABLE)
data class Track(
    @PrimaryKey (autoGenerate = true)
    @SerializedName(value = "trackId", alternate = ["collectionId"])
    @Nullable
    var id: Int,

    @SerializedName(value="trackName", alternate= ["collectionName"])
    @Nullable
    var name: String,

    @SerializedName(value="longDescription", alternate= ["shortDescription"])
    @Nullable
    var description: String,

    @SerializedName("artworkUrl100")
    var image: String,

    @SerializedName(value = "collectionPrice", alternate= ["trackPrice"])
    @Nullable
    var price: String,

    @SerializedName("primaryGenreName")
    @Nullable
    var genre: String
)

/** TODO
 * var description: String
 */


