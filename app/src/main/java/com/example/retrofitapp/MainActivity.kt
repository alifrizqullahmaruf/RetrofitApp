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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rickRecyclerView = findViewById<RecyclerView>(R.id.ry_character)

        ApiConfig.getService().getRick().enqueue(object : Callback<ResponseRick> {
            override fun onResponse(call: Call<ResponseRick>, response: Response<ResponseRick>) {
                if (response.isSuccessful) {
                    val responseRick = response.body()
                    val dataRick = responseRick?.results

                    val rickAdapter = RickAdapter(dataRick as List<ResultsItem>)

                    rickRecyclerView.apply {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = rickAdapter
                    }

                    rickAdapter.setOnItemClickListener(object : RickAdapter.OnItemClickListener {
                        override fun onItemClick(result: ResultsItem) {
                            startActivity(
                                Intent(applicationContext, DescActivity::class.java)
                                    .putExtra("intent_Name", result.name)
                                    .putExtra("intent_Species", result.species)
                                    .putExtra("intent_status", result.status)
                                    .putExtra("intent_image", result.image)
                            )
                        }
                    })

                    rickAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ResponseRick>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
