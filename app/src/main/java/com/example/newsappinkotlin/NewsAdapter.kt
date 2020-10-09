package com.example.newsappinkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.newsappinkotlin.APIServices.NewsModel
import kotlinx.android.synthetic.main.news_card.view.*

//import  kotlinx.android.synthetic.main.news_card.view.*
class NewsAdapter(private  var News:MutableList<NewsModel>?):RecyclerView.Adapter<NewsAdapter.MYView>() {
    class MYView(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(newsmodel:NewsModel)
        {
            if(newsmodel.author==null||newsmodel.author=="null")
            {
                newsmodel.author=="not specified"
            }
            itemView.title.text=newsmodel.title
            itemView.link.text=newsmodel.url
            Glide.with(itemView).load(newsmodel.Image).transform(CenterCrop()).into(itemView.news_image)
            itemView.link.text=newsmodel.url
            itemView.author.text="author is: ${newsmodel.author}"

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYView {
        val viewinflater=LayoutInflater.from(parent.context).inflate(R.layout.news_card, parent, false)
        return MYView(viewinflater)
    }

    override fun getItemCount(): Int =News!!.size

    override fun onBindViewHolder(holder: MYView, position: Int) {
        val card=News!![position]
holder.bind(card)

    }
    fun addmoreNews(news: List<NewsModel>){
        this.News!!.addAll(news)
        notifyItemRangeInserted(
            this.News!!.size,
            News!!.size - 1
        )
    }

}