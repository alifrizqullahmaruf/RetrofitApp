package com.example.retrofitapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Main activity responsible for displaying a list of Rick and Morty characters
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Reference to the RecyclerView in the layout
        val rickRecyclerView = findViewById<RecyclerView>(R.id.ry_character)

        // Make a network request using Retrofit to get Rick and Morty character data
        ApiConfig.getService().getRick().enqueue(object : Callback<ResponseRick> {
            override fun onResponse(call: Call<ResponseRick>, response: Response<ResponseRick>) {
                if (response.isSuccessful) {
                    // Retrieve the response body and extract the list of characters
                    val responseRick = response.body()
                    val dataRick = responseRick?.results

                    // Create an adapter and pass the character data to it
                    val rickAdapter = RickAdapter(dataRick as List<ResultsItem>)

                    // Set up the RecyclerView with a LinearLayoutManager and the adapter
                    rickRecyclerView.apply {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = rickAdapter
                    }

                    // Set item click listener to handle click events on RecyclerView items
                    rickAdapter.setOnItemClickListener(object : RickAdapter.OnItemClickListener {
                        override fun onItemClick(result: ResultsItem) {
                            // Open a new activity (DescActivity) with details of the clicked character
                            startActivity(
                                Intent(applicationContext, DescActivity::class.java)
                                    .putExtra("intent_Name", result.name)
                                    .putExtra("intent_Species", result.species)
                                    .putExtra("intent_status", result.status)
                                    .putExtra("intent_image", result.image)
                            )
                        }
                    })

                    // Notify the adapter that the data set has changed
                    rickAdapter.notifyDataSetChanged()
                }
            }

            // Handle failure in the network request
            override fun onFailure(call: Call<ResponseRick>, t: Throwable) {
                // Display a toast message with the error information
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
