package android.com.jamsand.io.foreignexchangerate.view

import android.com.jamsand.io.foreignexchangerate.R
import android.com.jamsand.io.foreignexchangerate.databinding.FragmentBlankBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {

//    https://fxmarketapi.com/apiconvert
//    ?api_key=KPohBD8rGCsg7DRE3o6t
//    & from=EUR
//    & to=SEK
//    & amount=1000

     lateinit var  binding: FragmentBlankBinding
    // TODO: Rename and change types of parameters
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

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false)

        binding.btnConvertCurrency.setOnClickListener {

            //create bundle to pass rateExchange details

            val bundle2 = Bundle()
            bundle2.putString("from","EUR")
            bundle2.putString("to","SEK")
            bundle2.putString("amount","10")



            it.findNavController().navigate(R.id.action_blankFragment_to_blankFragment2, bundle2)
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }




}