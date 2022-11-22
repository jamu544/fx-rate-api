package android.com.jamsand.io.foreignexchangerate.model

import com.google.gson.annotations.SerializedName
//    https://fxmarketapi.com/apiconvert
//    ?api_key=KPohBD8rGCsg7DRE3o6t
//    & from=EUR
//    & to=SEK
//    & amount=1000

//                val price = requireArguments().getString("price")
//                val timeStamp = requireArguments().getString("timeStamp")
//                val totalPrice = requireArguments().getString("totalPrice")
//                val fromCurrency = requireArguments().getString("fromCurrency")
//                val toCurrency = requireArguments().getString("toCurrency")


//{
//    "price": 10.2477,
//    "timestamp": 1544112937,
//    "total": 10247.7,
//    "from":"EUR"
//    "to":"SEK"
//}

data class ExchangeRate(
    @SerializedName("price") val price: String,
    @SerializedName("timestamp") val timestamp: String,
    @SerializedName("total") val total: String,
    @SerializedName("from") val from: String,
    @SerializedName("to") val to: String
)
