package com.example.kotlinvaccineapp_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val vaccineList: ArrayList<VaccineModel>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //creating the whole view setup --> detailing what layout to use
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout,parent,false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return vaccineList.size
    }

    // updating the viewholder to bind and setup each indiv view unit
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.vaccineTitle.setText(vaccineList[position].title)
        holder.vaccineImage.setImageResource(vaccineList[position].image)



    }


    //Initializer of each view unit
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var vaccineImage: ImageView
        var vaccineTitle: TextView

        init {
            vaccineImage = itemView.findViewById(R.id.imageView)
            vaccineTitle = itemView.findViewById(R.id.textView)

            itemView.setOnClickListener(){
                Toast.makeText(itemView.context,""+"hello",Toast.LENGTH_SHORT).show()
            }
        }
    }
}