package com.example.karhabtifinal.ActionsAnnonceMecanicienInspection.Annonce


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.karhabtifinal.ListesAnnonceInspectionMecanicien.Annonce.AnnoncesAdapter
import com.example.karhabtifinal.R
import com.example.karhabtifinal.data.Annonce.Annonce
import com.example.karhabtifinal.data.Annonce.AnnonceList
import com.example.karhabtifinal.network.Retro
import com.example.karhabtifinal.network.UserApi
import retrofit2.Response


class AnnoncesFragment : Fragment() {


    lateinit var recylcerAnnonce: RecyclerView
    lateinit var recylcerAnnoncesAdapter: AnnoncesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_annonces, container, false)



        recylcerAnnonce = view.findViewById(R.id.recyclerAnnonce)
        var annonceList: MutableList<Annonce> = ArrayList()

        recylcerAnnoncesAdapter = AnnoncesAdapter(annonceList, requireContext())

        recylcerAnnonce.adapter = recylcerAnnoncesAdapter

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.AnnonceList().enqueue(object : retrofit2.Callback<AnnonceList> {
            override fun onResponse(
                call: retrofit2.Call<AnnonceList>,
                response: Response<AnnonceList>
            ) {
                response.body()?.annonce?.let { annonceList.addAll(it) }
                recylcerAnnoncesAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: retrofit2.Call<AnnonceList>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        })

        recylcerAnnonce.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return view


    }
}

//private fun doList() {
//  var annonceliste : MutableList<Annonce> = ArrayList()
//   val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
//     retro.AnnonceList().enqueue(object : Callback<AnnonceList> {
//
//       //     override fun onResponse(call: Call<AnnonceList>, response: Response<AnnonceList>) {
//                Toast.makeText(context, "Liste in ", Toast.LENGTH_SHORT).show()
//                if (response.body().toString() != "")
//                //  Log.e("listNews", response.body().toString())
//                {
//                    val annonceList: AnnonceList = response.body() as AnnonceList
//                    // Log.e("list",response.body().toString())
//                    for (i: Annonce in annonceList.annonce) {
//                        annonceliste.add(
//                 //           Annonce(_id = i._id, title = i.title, description = i.description,date = i.date)
//                        )
//                        Toast.makeText(context, "ajout  ", Toast.LENGTH_SHORT).show()
//                    }
//                   // AnnonceAdapter = AnnonceAdapter(annonceliste)
//               //     annonceRecyclerView.adapter = AnnonceAdapter
//             //       annonceRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//                }
//            }
//
//            //override fun onFailure(call: Call<AnnonceList>, t: Throwable) {
//              //  Log.e("Error", t.message.toString())
//               // Toast.makeText(context, "Liste out ", Toast.LENGTH_SHORT).show()
//            //}
//        })
//
//    }
//}
//
