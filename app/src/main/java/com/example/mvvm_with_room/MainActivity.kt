package com.example.mvvm_with_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var tv=findViewById<TextView>(R.id.txtv)
//        var txt=findViewById<TextView>(R.id.txt)
//        var txarthor=findViewById<TextView>(R.id.txauthor)
        var btntv=findViewById<Button>(R.id.btnAddQuote)
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<Quote>()

        // This loop will create 20 Views containing
        // the image with the count of view


        // This will pass the ArrayList to our Adapter
        val adapter = adapter(data)

        // Setting the Adapter with the recyclerview


        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this, Observer {

//                 it.forEach {
//                     tv.text = it.id.toString()
             //   tv.text=it.toString()
//                txarthor.text=it.author
//                 }
            it.forEach{
                data.add(it)
                adapter.notifyDataSetChanged()
            }

        })
        recyclerview.adapter = adapter

        btntv.setOnClickListener{
            val quote = Quote(0, "This is testing", "Testing")
            mainViewModel.insertQuote(quote)
            adapter.notifyDataSetChanged()
        }
    }
}