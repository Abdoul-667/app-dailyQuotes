package com.example.dailyquotes

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritesActivity : AppCompatActivity() {

    private val prefs by lazy { getSharedPreferences("dq_prefs", Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val title = findViewById<TextView>(R.id.favTitle)
        val rv = findViewById<RecyclerView>(R.id.favRecycler)

        val isFrench = prefs.getBoolean("isFrench", true)
        title.text = if (isFrench) "Favoris" else "Favorites"

        rv.layoutManager = LinearLayoutManager(this)

        val favoriteIds = (prefs.getStringSet("favorite_ids", emptySet()) ?: emptySet())
            .mapNotNull { it.toIntOrNull() }
            .toSet()

        val all = QuoteRepository.allQuotes()
        val favQuotes = all.filter { favoriteIds.contains(it.id) }

        rv.adapter = FavoritesAdapter(
            quotes = favQuotes,
            isFrench = isFrench,
            onRemove = { quoteId ->
                val set = (prefs.getStringSet("favorite_ids", emptySet()) ?: emptySet()).toMutableSet()
                set.remove(quoteId.toString())
                prefs.edit().putStringSet("favorite_ids", set).apply()
                recreate()
            }
        )
    }
}
