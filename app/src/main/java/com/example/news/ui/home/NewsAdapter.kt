package com.example.news.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.databinding.ItemNewsBinding
import com.example.news.models.News

class NewsAdapter(private val onClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val list = arrayListOf<News>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
      return  ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.GRAY)
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE)

        }
        holder.itemView.setOnClickListener {
            onClick(position)
        }
    }

    override fun getItemCount() = list.size
    fun addItem(news: News?) {
        news?.let {
            list.add(0,it)
            notifyItemInserted(list.indexOf(news))
        }


    }

    fun getItem(it: Int): News {
        return list[it]

    }


    inner class ViewHolder( private var binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.textTittle.text=news.title

        }

       // private val textTittle: TextView = itemView.findViewById(R.id.textTittle)

    }
}