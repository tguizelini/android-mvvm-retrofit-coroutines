package br.com.tguizelini.androidmvvmcoroutines

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    val countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        myRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryAdapter
        }

        viewModel.fetchCountries()

        viewModel.items.observe(this, Observer {countries ->
            countries?.let {
                countryAdapter.update(it)
                Log.i("MainActivity", it.toString())
            }
        })
    }
}
