package com.brand.projectd.data.models

import androidx.annotation.Nullable
import androidx.room.Entity
import com.brand.projectd.util.Constants.DATABASE_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = DATABASE_TABLE)
data class Track(
    @SerializedName(value = "trackId", alternate = ["collectionId"])
    @Nullable
    var id: Int,

    @SerializedName(value="trackName", alternate= ["collectionName"])
    @Nullable
    var name: String,

//     @SerializedName("artworkUrl100")
//    var image: String,

    @SerializedName(value = "collectionPrice", alternate= ["trackPrice"])
    @Nullable
    var price: String,

    @SerializedName("primaryGenreName")
    @Nullable
    var genre: String
)

/** TODO
 * var artWork: String
 * var description: String
 */


