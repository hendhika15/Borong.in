package com.kampus.borongin.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kampus.borongin.R

class ListItemAdapter(private val listItem : ArrayList<Item>): RecyclerView.Adapter<ListItemAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (number, foto) = listItem[position]
        holder.imgFoto.setImageResource(foto)
        holder.tvNumber.text = number
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listItem[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listItem.size

    class ListViewHolder(iv: View): RecyclerView.ViewHolder(iv){
        var tvNumber : TextView = iv.findViewById(R.id.tv_item_number)
        var imgFoto : ImageView = iv.findViewById(R.id.img_item_foto)
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Item)
    }
}