package android.com.jamsand.io.foreignexchangerate.network
import android.com.jamsand.io.foreignexchangerate.utilities.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    var retrofitService: RestApi? = null
    fun getInstance() : RestApi {
        if (retrofitService == null){
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
            retrofitService = retrofit.create(RestApi::class.java)
        }
        return retrofitService!!
    }
}