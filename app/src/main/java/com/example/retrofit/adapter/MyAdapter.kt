package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.RowLayoutBinding
import com.example.retrofit.model.Post

class MyAdapter:RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var binding: RowLayoutBinding
    private var list = emptyList<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        binding.apply {
            tvUserId.text = list[position].userId.toString()
            tvId.text = list[position].id.toString()
            tvTitle.text = list[position].title
            tvBody.text = list[position].body
        }
    }

    inner class MyViewHolder(binding: RowLayoutBinding):RecyclerView.ViewHolder(binding.root){

    }

    fun setData(newList: List<Post>){
        list = newList
        notifyDataSetChanged()
    }

}








//
//class FoodAdapter(private val context: Context, var foods: List<FoodItem>, val clickListener: OnFoodClickListener): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
//        val binding = ActivityFoodBinding.inflate(LayoutInflater.from(context), parent, false)
//
//        return FoodViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
//        val food = foods[position]
//        holder.setData(food, clickListener)
//    }
//
//    override fun getItemCount(): Int {
//        return foods.size
//    }
//
//
//    inner class FoodViewHolder(val binding:ActivityFoodBinding): RecyclerView.ViewHolder(binding.root){
//        fun setData(food: FoodItem, action: OnFoodClickListener) {
//            binding.apply {
//                foodName.text = food.name
//                time.text = food.time.toString()
//                difficulty.text = food.difficulty
//                foodRatingValue.text = food.foodRatingValue.toString()
//                foodImage.setImageResource(food.image)
//            }
//            binding.root.setOnClickListener {
//                action.onFoodClick(food,adapterPosition)
//            }
//
//        }
//
//    }
//
//    interface OnFoodClickListener {
//        fun onFoodClick(food:FoodItem,position: Int)
//    }
//}