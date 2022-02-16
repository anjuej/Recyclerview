package com.example.mvvmorderitem

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmorderitem.databinding.*

class OrderAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val orderlist: ArrayList<Model> = ArrayList()


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(it: ArrayList<Model>) {
        orderlist.clear()
        orderlist.addAll(it)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ORDER -> orderViewHolder.from(parent)
            DELIVERY_DATE -> dateViewHolder.from(parent)
            ORDER_PRODUCT -> productsViewHolder.from(parent)
            ORDER_COMMENT -> commentViewHolder.from(parent)
            ORDER_CHARGES -> chargeViewHolder.from(parent)
            ORDER_DELIVERY_DETAILS -> deliveyViewHolder.from(parent)
            else -> paymentViewHolder.from(parent)

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder.itemViewType) {
            VIEW_TYPE_ORDER -> (holder as orderViewHolder).bind(item.orderModel)
            DELIVERY_DATE -> (holder as dateViewHolder).bind(item.orderModel)
            ORDER_PRODUCT -> (holder as productsViewHolder).bind(item.productModel)
            ORDER_COMMENT -> (holder as commentViewHolder).bind(item.orderModel)
            ORDER_CHARGES -> (holder as chargeViewHolder).bind(item.orderModel)
            ORDER_DELIVERY_DETAILS -> (holder as deliveyViewHolder).bind(item.orderModel)
            else -> (holder as paymentViewHolder).bind(item.orderModel)
        }
    }

    override fun getItemCount(): Int {
        return orderlist.size
    }

    override fun getItemViewType(position: Int): Int {

        return when (orderlist[position].type) {
            "order" -> VIEW_TYPE_ORDER
            "date" -> DELIVERY_DATE
            "products" -> ORDER_PRODUCT
            "comment" -> ORDER_COMMENT
            "amount" -> ORDER_CHARGES
            "delivery" -> ORDER_DELIVERY_DETAILS
            else -> ORDER_PAYMENT_METHOD

        }
    }

    class orderViewHolder private constructor(val binding: LayoutOrderdetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(order: OrderModel?) {
            binding.orderbinding = order
        }

        companion object {
            fun from(parent: ViewGroup): orderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutOrderdetailsBinding.inflate(layoutInflater, parent, false)
                return orderViewHolder(binding)
            }
        }
    }

    class dateViewHolder private constructor(val binding: LayoutDeliverydateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(date: OrderModel?) {
            binding.deliverydatebinding = date
        }

        companion object {
            fun from(parent: ViewGroup): dateViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutDeliverydateBinding.inflate(layoutInflater, parent, false)
                return dateViewHolder(binding)
            }
        }
    }

    class productsViewHolder private constructor(val binding: LayoutOrderitemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(products: ProductModel?) {
            binding.productsbinding = products
        }

        companion object {
            fun from(parent: ViewGroup): productsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutOrderitemsBinding.inflate(layoutInflater, parent, false)
                return productsViewHolder(binding)
            }
        }
    }

    class commentViewHolder private constructor(val binding: LayoutMsgBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: OrderModel?) {
            binding.commentbinding = comment
        }

        companion object {
            fun from(parent: ViewGroup): commentViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutMsgBinding.inflate(layoutInflater, parent, false)
                return commentViewHolder(binding)
            }
        }
    }

    class chargeViewHolder private constructor(val binding: LayoutPriceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(amount: OrderModel?) {
            binding.chargesbinding = amount
        }

        companion object {
            fun from(parent: ViewGroup): chargeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutPriceBinding.inflate(layoutInflater, parent, false)
                return chargeViewHolder(binding)
            }
        }
    }

    class deliveyViewHolder private constructor(val binding: LayoutCalldetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(delivery: OrderModel?) {
            binding.deliveryaddressbinding = delivery
        }

        companion object {
            fun from(parent: ViewGroup): deliveyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutCalldetailsBinding.inflate(layoutInflater, parent, false)
                return deliveyViewHolder(binding)
            }
        }
    }

    class paymentViewHolder private constructor(val binding: LayoutPaymentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(payment: OrderModel?) {
            binding.paymentbinding = payment
        }

        companion object {
            fun from(parent: ViewGroup): paymentViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutPaymentBinding.inflate(layoutInflater, parent, false)
                return paymentViewHolder(binding)
            }
        }
    }

    private fun getItem(position: Int): Model {
        return orderlist[position]

    }


}