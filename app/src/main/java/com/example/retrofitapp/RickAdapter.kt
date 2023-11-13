package com.example.retrofitapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RickAdapter(val dataRick: List<ResultsItem>) : RecyclerView.Adapter<RickAdapter.MyViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(result: ResultsItem)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgRick = view.findViewById<ImageView>(R.id.item_image_Rick)
        val nameRick = view.findViewById<TextView>(R.id.item_name_rick)
        val statusRick = view.findViewById<TextView>(R.id.item_status_rick)
        val speciesRick = view.findViewById<TextView>(R.id.item_species_rick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataRick.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameRick.text = dataRick[position].name
        holder.statusRick.text = dataRick[position].status
        holder.speciesRick.text = dataRick[position].species

        Glide.with(holder.itemView.context)
            .load(dataRick[position].image)
            .into(holder.imgRick)

        holder.itemView.setOnClickListener {
            listener?.onItemClick(dataRick[position])
        }
    }
}
