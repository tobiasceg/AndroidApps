package com.example.kotlinworldcupapp_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1-Adapter View: Listview
        var listview: ListView = findViewById<ListView>(R.id.listView)

        // 2- Adapter
        var adapter = MyAdapter(this, generateData())

        //4- connect listview to adapter
        listview?.adapter = adapter
        adapter.notifyDataSetChanged()


    }

    // 3 - data source
    fun generateData(): ArrayList<CountryModel>{
        var res = ArrayList<CountryModel>()

        var country1 : CountryModel = CountryModel(
            "Germany",
            R.drawable.ic_launcher_foreground
        )

        var country2: CountryModel = CountryModel(
            "Brazil",
            R.drawable.ic_launcher_background
        )

        var country3 : CountryModel = CountryModel(
            "Qatar",
            R.drawable.ic_launcher_foreground
        )

        res.add(country1)
        res.add(country2)
        res.add(country3)

        return res
    }
}