package android.com.jamsand.io.foreignexchangerate.model

import com.google.gson.annotations.SerializedName

data class ExchangeRate(
    @SerializedName("price") val price: String,
    @SerializedName("timestamp") val timestamp: String,
    @SerializedName("total") val total: String,
    @SerializedName("from") val from: String,
    @SerializedName("to") val to: String
)
