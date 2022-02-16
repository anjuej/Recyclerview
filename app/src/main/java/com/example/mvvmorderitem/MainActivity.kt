package com.example.mvvmorderitem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmorderitem.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var orderAdapter: OrderAdapter
   private lateinit var orderViewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinging()
        setUpRecylerview()
        setUpObserver()
    }

    private fun setUpObserver() {
        orderViewModel.getList().observe(this){
                if (!it.isNullOrEmpty()){
                        orderAdapter.submitList(it)
                }
        }

    }

    private fun setUpRecylerview() {
        orderAdapter=OrderAdapter()
            binding.recylerview.adapter=orderAdapter
    }

    private fun setUpBinging() {
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        orderViewModel=ViewModelProvider(this).get(OrderViewModel::class.java)
        binding.orderviewmodel=orderViewModel
        binding.lifecycleOwner=this

    }
}