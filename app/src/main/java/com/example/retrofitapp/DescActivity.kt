package com.example.retrofitapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desc)

        supportActionBar?.title = intent.getStringExtra("intent_Name")

        val speciesTextView = findViewById<TextView>(R.id.Sepcies)
        val statusTextView = findViewById<TextView>(R.id.status)
        val imageCharacterImageView = findViewById<ImageView>(R.id.image_character)

        speciesTextView.text = intent.getStringExtra("intent_Species")
        statusTextView.text = intent.getStringExtra("intent_status")

        Glide.with(this)
            .load(intent.getStringExtra("intent_image"))
            .into(imageCharacterImageView)
    }
}
