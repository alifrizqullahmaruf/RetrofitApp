package com.example.retrofitapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

// Activity responsible for displaying detailed information about a selected Rick and Morty character
class DescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desc)

        // Set the action bar title to the character's name received from the intent
        supportActionBar?.title = intent.getStringExtra("intent_Name")

        // References to TextViews and ImageView in the layout
        val NameTextView = findViewById<TextView>(R.id.Name)
        val speciesTextView = findViewById<TextView>(R.id.Sepcies)
        val statusTextView = findViewById<TextView>(R.id.status)
        val imageCharacterImageView = findViewById<ImageView>(R.id.image_character)

        // Set the species and status information from the intent to the respective TextViews
        NameTextView.text = intent.getStringExtra("intent_Name")
        speciesTextView.text = intent.getStringExtra("intent_Species")
        statusTextView.text = intent.getStringExtra("intent_status")

        // Load the character image from the intent into the ImageView using Glide
        Glide.with(this)
            .load(intent.getStringExtra("intent_image"))
            .into(imageCharacterImageView)
    }
}
