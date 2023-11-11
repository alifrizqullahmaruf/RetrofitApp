package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menginisialisasi RecyclerView dari layout
        val rickRecyclerView = findViewById<RecyclerView>(R.id.ry_character)

        // Menggunakan ApiService untuk mendapatkan data karakter menggunakan Retrofit
        ApiConfig.getService().getRick().enqueue(object : Callback<ResponseRick> {
            override fun onResponse(call: Call<ResponseRick>, response: Response<ResponseRick>) {
                if (response.isSuccessful) {
                    // Jika respons berhasil, mengambil data karakter dari respons
                    val responseRick = response.body()
                    val dataRick = responseRick?.results

                    // Membuat adapter untuk RecyclerView
                    val rickAdapter = RickAdapter(dataRick as List<ResultsItem>)

                    // Mengatur layout manager dan adapter untuk RecyclerView
                    rickRecyclerView.apply {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = rickAdapter
                    }

                    // Memberitahu adapter bahwa data telah berubah
                    rickAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ResponseRick>, t: Throwable) {
                // Menangani kesalahan jika permintaan gagal
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
