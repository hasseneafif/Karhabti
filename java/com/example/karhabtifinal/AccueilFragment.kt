package com.example.karhabtifinal


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.karhabtifinal.databinding.FragmentAccueilBinding
import kotlinx.android.synthetic.main.fragment_accueil.*

class AccueilFragment : Fragment() {

    private var _binding: FragmentAccueilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAccueilBinding.inflate(inflater, container, false)
        binding.buttonSearch.setOnClickListener {
            findNavController().navigate(R.id.accueil_to_Annonce)
        }

        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


//
//
// Fragment(R.layout.fragment_accueil) {
//
//    var navController: NavController? = null
//    var arrayOfColors = arrayOf(Color.GREEN)
//    var size = arrayOfColors.size
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        buttonSearch.setOnClickListener {
//    //        val action = AccueilFragmentDirections.accueilToAnnonce()
//     //       findNavController().navigate(action)
//        }
//        /*   view.findViewById<Button>(R.id.buttonSearch)
//           val recherche = view.findViewById<Button>(R.id.buttonSearch)
//           val voiture1 = view.findViewById<ImageView>(R.id.voiture1)
//           val voiture2 = view.findViewById<ImageView>(R.id.voiture2)
//           val voiture3 = view.findViewById<ImageView>(R.id.voiture3)
//           val voiture4 = view.findViewById<ImageView>(R.id.voiture4)
//           val voiture5 = view.findViewById<ImageView>(R.id.voiture5)
//           val voiture6 = view.findViewById<ImageView>(R.id.voiture6)
//           val voiture7 = view.findViewById<ImageView>(R.id.voiture7)
//           val voiture8 = view.findViewById<ImageView>(R.id.voiture8)
//           val voiture9 = view.findViewById<ImageView>(R.id.voiture9)
//           val voiture10 = view.findViewById<ImageView>(R.id.voiture10)
//           val voiture11 = view.findViewById<ImageView>(R.id.voiture11)
//           val voiture12 = view.findViewById<ImageView>(R.id.voiture12)
//
//           voiture1?.setOnClickListener {
//               voiture1.setColorFilter(arrayOfColors[nextInt(size)])
//           }
//
//           voiture2?.setOnClickListener {
//               voiture2.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//
//           voiture3?.setOnClickListener {
//               voiture3.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//
//           voiture4?.setOnClickListener {
//               voiture4.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//
//           voiture5?.setOnClickListener {
//               voiture5.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//
//           voiture6?.setOnClickListener {
//               voiture6.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//
//           voiture7?.setOnClickListener {
//               voiture7.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//
//           voiture8?.setOnClickListener {
//               voiture8.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//
//           voiture9?.setOnClickListener {
//               voiture9.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//
//           voiture10?.setOnClickListener {
//               voiture10.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//           voiture11?.setOnClickListener {
//               voiture11.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//
//           voiture12?.setOnClickListener {
//               voiture12.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//           voiture12?.setOnClickListener {
//               voiture12.setColorFilter(arrayOfColors[nextInt(size)])
//
//           }
//           recherche?.setOnClickListener {
//
//           }
//   */
//
//    }
//
//}