package com.example.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.adapter.CustomAdapter
import com.example.mvvmdemo.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mUserMainViewModel: MainViewModel
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    var lastItem: Int? = null
    val tag = "mvvm"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        linearLayoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = linearLayoutManager

        mUserMainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mUserMainViewModel.fetch()


        val adapter = CustomAdapter(mUserMainViewModel.data)

        val ab = getItem()
        Log.e(tag, "onCreate$ab")

        ab?.let { (recyclerView.layoutManager as LinearLayoutManager).scrollToPosition(it) }

        recyclerView.adapter = adapter
    }

    private fun getItem(): Int? {
        lastItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition()
        return lastItem
    }

    override fun onPause() {
        super.onPause()
        val item = getItem()
        Log.e(tag, "onPause$item")

    }

    override fun onResume() {
        super.onResume()
        val ab = getItem()
        Log.e(tag, "onResume$ab")
        ab?.let { (recyclerView.layoutManager as LinearLayoutManager).scrollToPosition(it) }
    }
}