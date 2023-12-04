package com.example.kotlinworldcupapp_listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter(private var activity: MainActivity, private var items: ArrayList<CountryModel> ): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): CountryModel {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder : ViewHolder

        if (convertView == null){
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            view = inflater.inflate(R.layout.list_item,null) // view is the whole thing
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        }
        else {
            view = convertView // convertView is for recycling, converting the views that are out of screen to the ones in screen
            viewHolder = view.tag as ViewHolder
        }

        // Actually creating and binding the data to each indiv view units by the viewholder
        var countries = items[position]
        viewHolder.txtName?.text = countries.name
        viewHolder.flagImage?.setImageResource(countries.Image)

        //onclickevent --> why view n not viewHolder = as its everyone click will get
        view?.setOnClickListener(){
            Toast.makeText(activity,""+countries.name,Toast.LENGTH_SHORT).show()
        }

        return view as View
    }

    private class ViewHolder(row: View?){ // initializing each indiv view unit
        var txtName: TextView? = null
        var flagImage: ImageView? = null

        init {
            this.txtName = row?.findViewById(R.id.textView)
            this.flagImage = row?.findViewById(R.id.imageView)
        }
    }
}