
package com.example.dogglers.adapter

import android.content.Context
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {


    val dataset = DataSource.dogs

    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {

        val dogImageView: ImageView? = view?.findViewById(R.id.dog_image)
        val dogNameTextView: TextView? = view?.findViewById(R.id.dog_name)
        val dogAgeTextView: TextView? = view?.findViewById(R.id.dog_age)
        val dogHobbiesTextView: TextView? = view?.findViewById(R.id.dog_hobbies)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {

        val adapterLayout = when(layout) {
            Layout.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item,parent,false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item,parent,false)
        }


        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val item = dataset[position]
        holder.dogImageView?.setImageResource(item.imageResourceId)
        holder.dogNameTextView?.text = item.name

        holder.dogAgeTextView?.text = context?.resources?.getString(R.string.dog_age, item.age)

        val resources = context?.resources

        holder.dogHobbiesTextView?.text =resources?.getString(R.string.dog_hobbies, item.hobbies)
    }
}
