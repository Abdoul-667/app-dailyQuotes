package com.example.dailyquotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoritesAdapter(
    private val quotes: List<Quote>,
    private val isFrench: Boolean,
    private val onRemove: (Int) -> Unit
) : RecyclerView.Adapter<FavoritesAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quoteText: TextView = itemView.findViewById(R.id.itemQuoteText)
        val authorText: TextView = itemView.findViewById(R.id.itemAuthorText)
        val removeIcon: ImageView = itemView.findViewById(R.id.itemRemove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val q = quotes[position]
        holder.quoteText.text = if (isFrench) q.textFr else q.textEn
        holder.authorText.text = "— ${q.author}"
        holder.removeIcon.setOnClickListener { onRemove(q.id) }
    }

    override fun getItemCount(): Int = quotes.size
}
