package com.example.karhabtifinal.ActionsAnnonceMecanicienInspection.Inspection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.karhabtifinal.R
import com.example.karhabtifinal.ListesAnnonceInspectionMecanicien.Inspection.InspectionAdapter
import com.example.karhabtifinal.data.Inspection.Inspection
import com.example.karhabtifinal.network.Retro
import com.example.karhabtifinal.network.UserApi


class InspectionFragment : Fragment() {


    lateinit var recylcerInspection: RecyclerView
    lateinit var recylcerInspectionAdapter: InspectionAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view=inflater.inflate(R.layout.fragment_inspection,container,false)



        recylcerInspection = view.findViewById(R.id.recyclerInspection)
        var inspectionList : MutableList<Inspection> = ArrayList()





        recylcerInspectionAdapter = InspectionAdapter(inspectionList)

        recylcerInspection.adapter = recylcerInspectionAdapter

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
//        retro.InspectionList().enqueue(object: retrofit2.Callback<InspectionList> {
//            override fun onResponse(
//                call: retrofit2.Call<InspectionList>,
//                response: Response<InspectionList>
//            ) {
//                response.body()?.inspection?.let { inspectionList.addAll(it) }
//                recylcerInspectionAdapter.notifyDataSetChanged()
//            }
//
//            override fun onFailure(call: retrofit2.Call<InspectionList>, t: Throwable) {
//                Log.e("Error",t.message.toString())
//            }
//
//        })

        recylcerInspection.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)
        return view



    }}