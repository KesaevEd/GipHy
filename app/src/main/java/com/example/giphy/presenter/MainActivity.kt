package com.example.giphy.presenter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giphy.R
import com.example.giphy.adapters.GifsAdapter
import com.example.giphy.databinding.ActivityMainBinding
import com.example.giphy.domain.Common
import com.example.giphy.domain.RetrofitApi
import com.example.giphy.models.GifsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mService: RetrofitApi

    lateinit var layoutManagerGifs: LinearLayoutManager
    lateinit var gifsAdapter: GifsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            mService = Common.retrofitApi
            recViewGifs.setHasFixedSize(true)
            layoutManagerGifs = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            recViewGifs.layoutManager = layoutManagerGifs
            getGifs()
            searchButton.setOnClickListener {
                try {
                val title = searchEditText.text.toString()
                searchGifs(title)
                }catch (e:Exception) {Toast.makeText(this@MainActivity, "Введите текст на английском языке", Toast.LENGTH_SHORT).show()}
            }
        }
    }

    private fun getGifs() {
        binding.apply {

            mService.getGifs().enqueue(object : Callback<GifsData> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<GifsData>,
                    response: Response<GifsData>
                ) {
                    gifsAdapter = GifsAdapter(baseContext, response.body()!!.data)
                    gifsAdapter.notifyDataSetChanged()
                    recViewGifs.adapter = gifsAdapter


                }

                override fun onFailure(call: Call<GifsData>, t: Throwable) {

                }

            })
        }
    }

    private fun searchGifs(title: String){
        binding.apply {

            mService.searchGifs(title).enqueue(object: Callback<GifsData> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<GifsData>,
                    response: Response<GifsData>
                ) {
                    gifsAdapter = GifsAdapter(baseContext, response.body()!!.data)
                    Log.d("DOG", "${response.body()}")
                    gifsAdapter.notifyDataSetChanged()
                    recViewGifs.adapter = gifsAdapter

                }

                override fun onFailure(call: Call<GifsData>, t: Throwable) {

                }

            })
        }
    }
}