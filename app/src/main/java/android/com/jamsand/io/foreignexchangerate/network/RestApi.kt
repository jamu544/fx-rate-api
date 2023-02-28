package android.com.jamsand.io.foreignexchangerate.network

import android.com.jamsand.io.foreignexchangerate.model.ExchangeRate
import android.com.jamsand.io.foreignexchangerate.utilities.Constants.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RestApi {
    @Headers("Content-Type: application/json")
    @GET("/apiconvert")
    fun getExchangeRateResults(@Query("api_key") api_key: String,
       @Query("from") from:String,
       @Query("to") to:String,
       @Query("amount")amount:Int)
        : Call<ExchangeRate>

    companion object {

        var retrofitService: RestApi? = null
        fun getInstance() : RestApi {
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                retrofitService = retrofit.create(RestApi::class.java)
            }
            return retrofitService!!
        }


    }
}