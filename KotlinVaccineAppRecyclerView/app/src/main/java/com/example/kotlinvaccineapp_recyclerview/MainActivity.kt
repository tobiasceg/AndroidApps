package com.example.kotlinvaccineapp_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1 - AdapterView: RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        // 2 - Data soruces: List of VaccineModel obj
        var vaccineList : ArrayList<VaccineModel> = ArrayList()

        val v1 = VaccineModel("Covid-19", R.drawable.ic_launcher_background)
        val v2 = VaccineModel("Flu",R.drawable.ic_launcher_foreground)
        val v3 = VaccineModel("AIDS", R.drawable.ic_launcher_background)
        val v4 = VaccineModel("diabetes", R.drawable.ic_launcher_foreground)
        val v5 = VaccineModel("No clue anym", R.drawable.ic_launcher_background)
        val v6 = VaccineModel("more", R.drawable.ic_launcher_foreground)
        val v7 = VaccineModel("jsut to scroll",R.drawable.ic_launcher_background)

        vaccineList.add(v1)
        vaccineList.add(v2)
        vaccineList.add(v3)
        vaccineList.add(v4)
        vaccineList.add(v5)
        vaccineList.add(v6)
        vaccineList.add(v7)


        // 3 - Adapter
        val adapter = MyAdapter(vaccineList)

        // combinging recyclerview with adapter
        recyclerView.adapter = adapter


    }
}