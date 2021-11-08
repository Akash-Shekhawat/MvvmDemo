package com.example.mvvmdemo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.R
import com.example.mvvmdemo.model.DataItem

class MainViewModel: ViewModel() {
    val data = ArrayList<DataItem>()
    fun fetch(){
        for (i in 1..100) {
            data.add(DataItem(R.drawable.ic_launcher_foreground, "Item $i"))
        }}

}