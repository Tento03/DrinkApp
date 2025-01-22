package com.example.drinkapp.drink

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.drinkapp.api.Drink
import com.example.drinkapp.databinding.ItemDrinkBinding

val USER_COMPARATOR = object : DiffUtil.ItemCallback<Drink>() {
    override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean =
        // User ID serves as unique ID
        oldItem.idDrink == newItem.idDrink

    override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean =
        // Compare full contents (note: Java users should call .equals())
        oldItem == newItem
}

class DrinkAdapter(private val context: Context,private val onItemClickListener: onClickListener) : PagingDataAdapter<Drink, DrinkAdapter.DrinkViewHolder>(USER_COMPARATOR) {
    inner class DrinkViewHolder(var binding: ItemDrinkBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(drink: Drink){
            Glide.with(context)
                .load(drink.strDrinkThumb)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imgMeal)
            binding.tvMealName.text=drink.strDrink

            binding.root.setOnClickListener(){
                val position=bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION){
                    val item=getItem(position)
                    item?.let {
                        onItemClickListener.onItemClick(it)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        var binding=ItemDrinkBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DrinkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
//        val repoItem = getItem(position)
        // Note that item may be null, ViewHolder must support binding null item as placeholder
//        holder.bind(repoItem)
        val drink=getItem(position)
        drink?.let {
            holder.bind(it)
        }

    }
    interface onClickListener{
        fun onItemClick(drink: Drink)
    }
}