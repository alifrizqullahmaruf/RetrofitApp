package com.example.retrofitapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// Adapter class for the RecyclerView to display Rick characters
class RickAdapter(val dataRick: List<ResultsItem>) : RecyclerView.Adapter<RickAdapter.MyViewHolder>() {

    // Inner ViewHolder class to hold the views
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgRick = view.findViewById<ImageView>(R.id.item_image_Rick)
        val nameRick = view.findViewById<TextView>(R.id.item_name_rick)
        val statusRick = view.findViewById<TextView>(R.id.item_status_rick)
        val speciesRick = view.findViewById<TextView>(R.id.item_species_rick)
    }

    // Create ViewHolder instances
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    // Return the number of items in the data set
    override fun getItemCount(): Int {
        if(dataRick != null) {
            return dataRick.size
        }
            return 0
    }

    // Bind data to the views in each ViewHolder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Set the name, status, and species of the Rick character
        holder.nameRick.text = dataRick[position].name
        holder.statusRick.text = dataRick[position].status
        holder.speciesRick.text = dataRick[position].species

        // Load the image using Glide library (assuming you have it in your dependencies)
        Glide.with(holder.itemView.context)
            .load(dataRick[position].image)
            .into(holder.imgRick)

        holder.itemView.setOnClickListener{
            val name = dataRick?.get(position)?.name
            Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()
        }
    }
}
