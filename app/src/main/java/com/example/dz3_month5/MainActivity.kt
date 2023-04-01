package com.example.dz3_month5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dz3_month5.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var adapter = ImageAdapter(arrayListOf())
    var page = 1
    var name = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        binding.changeBtn.setOnClickListener {
            if (name != binding.keyWord.text.toString()) {
                name = binding.keyWord.text.toString()
                adapter.cleanImage()
                page = 1
                requestImage()
            } else {
                ++page
                requestImage()
            }
        }
        binding.searchBtn.setOnClickListener {
            name = binding.keyWord.text.toString()
            page = 1
            adapter.cleanImage()
            requestImage()
        }
    }

    private fun requestImage() {
        PixaService().api.getImage(binding.keyWord.text.toString(), page = page)
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse(call: Call<PixaModel>, response: Response<PixaModel>) {
                    if (response.isSuccessful) {
                        adapter.addImage(response.body()!!.hits)
                        binding.imageRecycler.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                    Log.d("ololo", "onFailure: ${t.message}")
                }
            })

    }
}