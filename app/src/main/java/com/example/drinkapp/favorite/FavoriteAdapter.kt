package com.example.drinkapp.favorite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.drinkapp.api.Drink
import com.example.drinkapp.databinding.ItemDrinkBinding

class FavoriteAdapter(private val dataSet: ArrayList<Favorite>,private val context: Context,
private var onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    inner class ViewHolder(var binding: ItemDrinkBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(favorite: Favorite){
            Glide.with(context)
                .load(favorite.strDrinkThumb)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imgMeal)
            binding.tvMealName.text=favorite.strDrink

            binding.root.setOnClickListener(){
                var position=bindingAdapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    var item=dataSet[position]
                    onItemClickListener.onItemClick(item)
                }
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding=ItemDrinkBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        viewHolder.textView.text = dataSet[position]
        var dataset=dataSet[position]
        viewHolder.bind(dataset)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun setNewList(newList:List<Favorite>){
        dataSet.addAll(newList)
        notifyDataSetChanged()
    }

    interface OnItemClickListener{
        fun onItemClick(favorite: Favorite)
    }

}