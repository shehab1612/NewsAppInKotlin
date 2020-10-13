package com.example.newsappinkotlin

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.newsappinkotlin.APIServices.NewsModel
import com.example.newsappinkotlin.database.AppDatabase
import kotlinx.android.synthetic.main.fragment_headlines.view.*
import kotlinx.android.synthetic.main.fragment_saved_items.*
import kotlinx.android.synthetic.main.fragment_saved_items.view.*
import kotlinx.android.synthetic.main.news_card.view.*
import kotlinx.android.synthetic.main.news_card.view.news_image
import kotlinx.android.synthetic.main.news_card.view.title
import kotlinx.android.synthetic.main.saved_news_card.view.*

class SavedNewsAdapter(private var News: MutableList<NewsModel>):RecyclerView.Adapter<SavedNewsAdapter.SavedViewHolder>() {
    class SavedViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


        fun bind(newsmodel:NewsModel)
        {
            itemView.title.text=newsmodel.title
            itemView.news_image.setImageBitmap(newsmodel.savedImage?.size?.let {
                BitmapFactory.decodeByteArray(newsmodel.savedImage , 0,
                    it
                )
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedViewHolder {
        val viewinflater=LayoutInflater.from(parent.context).inflate(R.layout.saved_news_card, parent, false)

        viewinflater.setOnClickListener {
            val itemPosition =parent.saved_news_recycler.getChildLayoutPosition(viewinflater)
            val bundle = bundleOf("news" to News?.get(itemPosition))
            parent.findNavController().navigate(R.id.action_savedItemsFragment_to_itemDetailsFragment, bundle)
        }

        viewinflater.unsave_btn.setOnClickListener {
            val itemPosition =parent.saved_news_recycler.getChildLayoutPosition(viewinflater)
            AppDatabase.getDatabase(parent.context).getNewsDao().delete(News[itemPosition])
            News.removeAt(itemPosition)
            Toast.makeText(parent.context,"REMOVED",Toast.LENGTH_SHORT).show()
            this.notifyDataSetChanged()

        }
        return SavedViewHolder(viewinflater)
    }

    override fun getItemCount(): Int =News!!.size
    override fun onBindViewHolder(holder: SavedViewHolder, position: Int) {
        News?.get(position)?.let { holder.bind(it) }
    }


}