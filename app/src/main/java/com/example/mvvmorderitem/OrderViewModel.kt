package com.example.mvvmorderitem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    var list=MutableLiveData<ArrayList<Model>>()
        init {
            list.value= ArrayList()
            getListitem()

        }
    fun getListitem(){
        val temp:ArrayList<Model> = ArrayList()
        val productlist : ArrayList<ProductModel> = ArrayList()

        productlist.add(ProductModel(1,"pizza",200,"medium"))
     //   productlist.add(ProductModel(2,"pizza",200,"medium"))

        val orderModel = OrderModel(1,"77","accepted","34",
            productlist,"user comment",200,20,
            20,300,"aaa","dfwd",212122,
            "gpay","success")

        //-------order-----
        temp.add(Model("order",orderModel,null))

        //-------delivery date-----
        temp.add(Model("date",orderModel,null))

        //------product details
        orderModel.productlist?.forEach{
            it1->
            temp.add(Model("products",null,it1))
        }

        //-------comment---------
        temp.add(Model("comment",orderModel,null))

        //-----product amount------
        temp.add(Model("amount",orderModel,null))


        //-----delivery details------
        temp.add(Model("delivery",orderModel,null))

        //------payment details------
        temp.add(Model("payment",orderModel,null))

        list.value=temp
    }
        fun getList(): LiveData<ArrayList<Model>>{
             return list
    }
}