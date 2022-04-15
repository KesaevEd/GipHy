package com.example.giphy.models

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class GifsData(
    @SerializedName("data") val data : ArrayList<Data>
)

data class Data(
    @SerializedName("images") val images : Images,
)

data class Images(
    @SerializedName("original") val original : Original
)

data class Original(
    @SerializedName("url") val url: String
)

