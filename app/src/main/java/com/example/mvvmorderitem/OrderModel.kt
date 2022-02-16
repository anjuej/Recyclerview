package com.example.mvvmorderitem

data class OrderModel (
    val orderid : Int?,
    val orderdate : String?,
    val status : String?,
    val deliverydate : String?,

    val productlist : ArrayList<ProductModel>?,
    val comment : String?,

    val totalamount : Int?,
    val gst : Int?,
    val deliverycharge : Int?,
    val totalpayment : Int?,

    val customername : String?,
    val address : String?,
    val customernumber : Int?,

    val paymentmode : String?,
    val paymentstatus : String?


        )