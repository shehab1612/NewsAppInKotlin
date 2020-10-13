package com.example.newsappinkotlin

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.newsappinkotlin.APIServices.NewsModel
import com.example.newsappinkotlin.database.AppDatabase
import kotlinx.android.synthetic.main.fragment_headlines.view.*
import kotlinx.android.synthetic.main.news_card.view.*
import java.io.ByteArrayOutputStream

//import  kotlinx.android.synthetic.main.news_card.view.*
class NewsAdapter(private var News: MutableList<NewsModel>?):RecyclerView.Adapter<NewsAdapter.MYView>() {
    lateinit var dataBase: AppDatabase
    class MYView(itemView: View):RecyclerView.ViewHolder(itemView) {


        fun bind(newsmodel:NewsModel)
        {
            itemView.title.text=newsmodel.title
            // itemView.link.text=newsmodel.url
            Glide.with(itemView).load(newsmodel.Image).transform(CenterCrop()).into(itemView.news_image)
            //  itemView.setOnClickListener()
            //newsmodel.savedImage=itemView.news_image
            //itemView.link.text=newsmodel.url
            //   itemView.author.text="author is: ${newsmodel.author}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYView {
        val viewinflater=LayoutInflater.from(parent.context).inflate(R.layout.news_card, parent, false)

        viewinflater.setOnClickListener {
            val itemPosition =parent.news_recycler.getChildLayoutPosition(viewinflater)
            val bundle = bundleOf("news" to News?.get(itemPosition))
            parent.findNavController().navigate(R.id.action_headlinesFragment_to_itemDetailsFragment, bundle)
        }

        viewinflater.save_btn.setOnClickListener {
            val itemPosition =parent.news_recycler.getChildLayoutPosition(viewinflater)
            dataBase = AppDatabase.getDatabase(parent.context)
            val newsmodel = News?.get(itemPosition)
            Glide.with(parent.context)
                .asBitmap()
                .load(newsmodel?.Image)
                .into(object : CustomTarget<Bitmap>(500,500) {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        val stream = ByteArrayOutputStream()

                        resource.compress(Bitmap.CompressFormat.PNG, 100, stream)

                        newsmodel?.savedImage = stream.toByteArray()
                        newsmodel?.let { it1 -> dataBase.getNewsDao().insertNews(it1) }

                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}
                })
            Toast.makeText(parent.context,"SAVED",Toast.LENGTH_SHORT).show()
        }
        return MYView(viewinflater)
    }

    override fun getItemCount(): Int =News!!.size

    override fun onBindViewHolder(holder: MYView, position: Int) {
        val card=News!![position]
        holder.bind(card)

    }
    fun addmoreNews(news: MutableList<NewsModel>){
        this.News!!.addAll(news)
        notifyItemRangeInserted(
            this.News!!.size,
            News!!.size - 1
        )
    }
    public interface onNewsClicked
    {
        fun onNewsClicked(position:Int)
    }

}