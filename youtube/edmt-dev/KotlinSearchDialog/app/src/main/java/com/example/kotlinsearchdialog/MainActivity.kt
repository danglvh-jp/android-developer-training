package com.example.kotlinsearchdialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat
import ir.mirrajabi.searchdialog.core.SearchResultListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSearch.setOnClickListener {
            SimpleSearchDialogCompat(this@MainActivity, "Search...",
                "What are you looking for...?", null, initData(),
                SearchResultListener { dialog, item, position ->
                    Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
                }).show()
        }
    }

    private fun initData(): ArrayList<SearchModel> {

        val items = ArrayList<SearchModel>()
        items.add(SearchModel("Captain America"))
        items.add(SearchModel("Superman"))
        items.add(SearchModel("Ironman"))
        items.add(SearchModel("Batman"))
        items.add(SearchModel("Spiderman"))
        items.add(SearchModel("Wonder Woman"))
        items.add(SearchModel("Zeus"))
        items.add(SearchModel("Hera"))
        items.add(SearchModel("Poseidon"))

        return items
    }
}