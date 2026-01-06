package com.example.dailyquotes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var dateText: TextView
    private lateinit var likeButton: TextView
    private lateinit var quoteText: TextView
    private lateinit var authorText: TextView
    private lateinit var bgImage: ImageView
    private lateinit var prevButton: AppCompatImageButton
    private lateinit var nextButton: AppCompatImageButton
    private lateinit var shareButton: AppCompatImageButton
    private lateinit var langButton: AppCompatImageButton
    private lateinit var favPageButton: AppCompatImageButton
    private lateinit var categorySpinner: Spinner

    private val prefs by lazy { getSharedPreferences("dq_prefs", Context.MODE_PRIVATE) }

    private var isFrench = true
    private var selectedCategory: Category = Category.MOTIVATION

    private val allQuotes: List<Quote> by lazy { QuoteRepository.allQuotes() }
    private var filteredQuotes: List<Quote> = emptyList()
    private var filteredIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        loadState()

        setupCategorySpinner()
        setupClicks()

        applyFilter(resetIndex = false)
        render()
    }

    private fun bindViews() {
        dateText = findViewById(R.id.dateText)
        likeButton = findViewById(R.id.likeButton)
        quoteText = findViewById(R.id.quoteText)
        authorText = findViewById(R.id.authorText)
        bgImage = findViewById(R.id.bgImage)

        prevButton = findViewById(R.id.prevButton)
        nextButton = findViewById(R.id.nextButton)
        shareButton = findViewById(R.id.shareButton)

        langButton = findViewById(R.id.langButton)
        favPageButton = findViewById(R.id.favPageButton)
        categorySpinner = findViewById(R.id.categorySpinner)
    }

    private fun loadState() {
        isFrench = prefs.getBoolean("isFrench", true)

        val savedCat = prefs.getString("selectedCategory", Category.MOTIVATION.name)
        selectedCategory = runCatching { Category.valueOf(savedCat ?: Category.MOTIVATION.name) }
            .getOrDefault(Category.MOTIVATION)

        filteredIndex = prefs.getInt("filteredIndex", 0)
    }

    private fun saveState() {
        prefs.edit()
            .putBoolean("isFrench", isFrench)
            .putString("selectedCategory", selectedCategory.name)
            .putInt("filteredIndex", filteredIndex)
            .apply()
    }

    private fun setupClicks() {
        nextButton.setOnClickListener { goNext() }
        prevButton.setOnClickListener { goPrev() }
        shareButton.setOnClickListener { shareCurrentQuote() }

        likeButton.setOnClickListener { toggleFavorite() }
        favPageButton.setOnClickListener { openFavorites() }

        langButton.setOnClickListener {
            isFrench = !isFrench
            saveState()
            setupCategorySpinner(keepSelection = true)
            render()
        }
    }

    private fun setupCategorySpinner(keepSelection: Boolean = false) {
        val categories = Category.values().toList()
        val labels = categories.map { cat -> if (isFrench) cat.labelFr else cat.labelEn }

        val adapter = ArrayAdapter(this, R.layout.spinner_item, labels)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)

        categorySpinner.adapter = adapter

        val currentPos = categories.indexOf(selectedCategory).coerceAtLeast(0)
        categorySpinner.setSelection(currentPos, false)

        categorySpinner.setOnItemSelectedListener(SimpleItemSelectedListener { position ->
            val newCat = categories.getOrNull(position) ?: Category.MOTIVATION
            if (newCat != selectedCategory || !keepSelection) {
                selectedCategory = newCat
                applyFilter(resetIndex = true)
                render()
            }
        })
    }

    private fun applyFilter(resetIndex: Boolean) {
        filteredQuotes = allQuotes.filter { it.category == selectedCategory }
        if (filteredQuotes.isEmpty()) filteredQuotes = allQuotes
        if (resetIndex) filteredIndex = 0
        filteredIndex = filteredIndex.coerceIn(0, filteredQuotes.lastIndex)
        saveState()
    }

    private fun currentQuote(): Quote = filteredQuotes[filteredIndex]

    private fun render() {
        val locale = if (isFrench) Locale.FRENCH else Locale.ENGLISH
        val fmt = SimpleDateFormat("d MMMM yyyy", locale)
        dateText.text = fmt.format(Date())

        val q = currentQuote()
        quoteText.text = if (isFrench) q.textFr else q.textEn
        authorText.text = "— ${q.author}"

        bgImage.setImageResource(backgroundForCategory(q.category))
        likeButton.text = if (isFavorite(q.id)) "♥" else "♡"

        saveState()
    }

    private fun goNext() {
        filteredIndex = (filteredIndex + 1) % filteredQuotes.size
        render()
    }

    private fun goPrev() {
        filteredIndex = if (filteredIndex - 1 < 0) filteredQuotes.lastIndex else filteredIndex - 1
        render()
    }

    private fun shareCurrentQuote() {
        val q = currentQuote()
        val text = if (isFrench) q.textFr else q.textEn
        val shareBody = "\"$text\"\n— ${q.author}"

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareBody)
        }
        startActivity(Intent.createChooser(intent, if (isFrench) "Partager" else "Share"))
    }

    private fun openFavorites() {
        startActivity(Intent(this, FavoritesActivity::class.java))
    }

    private fun favoritesKey(): String = "favorite_ids"

    private fun isFavorite(id: Int): Boolean {
        val set = prefs.getStringSet(favoritesKey(), emptySet()) ?: emptySet()
        return set.contains(id.toString())
    }

    private fun toggleFavorite() {
        val q = currentQuote()
        val idStr = q.id.toString()

        val set = (prefs.getStringSet(favoritesKey(), emptySet()) ?: emptySet()).toMutableSet()
        if (set.contains(idStr)) set.remove(idStr) else set.add(idStr)

        prefs.edit().putStringSet(favoritesKey(), set).apply()
        render()
    }

    private fun backgroundForCategory(category: Category): Int {
        return when (category) {
            Category.ANIME -> R.drawable.bg_anime
            Category.SPORT -> R.drawable.bg_sport
            Category.MOTIVATION -> R.drawable.bg_motivation
            Category.DISCIPLINE -> R.drawable.bg_discipline
            Category.CONFIANCE -> R.drawable.bg_confiance
            Category.ZEN -> R.drawable.bg_zen
            Category.DROLE -> R.drawable.bg_drole
        }
    }
}
