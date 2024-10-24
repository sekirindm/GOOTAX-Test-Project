package com.example.gootaxtestproject.presentation

import android.annotation.SuppressLint
import android.location.Address
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ContentInfoCompat.Flags
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gootaxtestproject.R
import com.example.gootaxtestproject.data.itemsForContainer
import com.example.gootaxtestproject.presentation.adapters.ContainerAdapter
import com.google.android.material.search.SearchBar
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvAddress = findViewById<TextView>(R.id.tv_address)
        val iv = findViewById<ImageView>(R.id.imageView)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        iv.setOnClickListener {
            drawerLayout.open()
        }

        tvAddress.setOnClickListener {
            SearchFragment().show(supportFragmentManager, "SearchFragment")
        }

        recyclerView = findViewById(R.id.rv_container)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = ContainerAdapter()
        recyclerView.adapter = adapter
        adapter.submitList(itemsForContainer)


        supportFragmentManager.setFragmentResultListener("requestKey", this) { _, bundle ->
            val selectedAddress = bundle.getString("selected_address")
            tvAddress.text = selectedAddress
        }
    }
}