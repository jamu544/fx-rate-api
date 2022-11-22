package android.com.jamsand.io.foreignexchangerate.view

import android.com.jamsand.io.foreignexchangerate.R
import android.com.jamsand.io.foreignexchangerate.databinding.FragmentBlank2Binding
import android.com.jamsand.io.foreignexchangerate.model.ExchangeRate
import android.com.jamsand.io.foreignexchangerate.network.RestApi
import android.com.jamsand.io.foreignexchangerate.utilities.Constants.API_KEY
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : Fragment() {
//    {
//        "price": 10.2477,
//        "timestamp": 1544112937,
//        "total": 10247.7,
//        "from":"EUR"
//        "to":"SEK"
//    }
    // TODO: Rename and change types of parameters
    lateinit var binding:FragmentBlank2Binding
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank2, container, false)
        val from = requireArguments().getString("from")
        val to = requireArguments().getString("to")
        val amount = requireArguments().getString("amount")

        //need to be tested
        returnExchange(API_KEY,"EUR","SEK",1000)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun returnExchange(api_key: String,from: String,to: String,amount: Int){
        val restApi = RestApi.getInstance().getExchangeRateResults(api_key,from, to, amount)

        restApi.enqueue(object : Callback<ExchangeRate>{
            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<ExchangeRate>, response: Response<ExchangeRate>) {

                if (response.isSuccessful){
                    binding.textViewPrice.text = response.body()?.price
                    binding.textViewTimeStamp.text = response.body()?.timestamp
                    binding.textViewTotal.text = response.body()?.total
                    binding.textViewFromCurrency.text = response.body()?.from
                    binding.textViewToCurrency.text = response.body()?.to

                    Log.i("response from Server ",response.body().toString())
//
                }
                else {
                    Log.i("response from Server 2 ",response.body().toString())
                }
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected exception
             * occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<ExchangeRate>, t: Throwable) {
                t.message?.let { Log.d("FAILURE", it.toString()) }
            }

        })


    }
}