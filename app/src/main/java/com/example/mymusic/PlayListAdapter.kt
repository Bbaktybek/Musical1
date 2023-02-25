package com.example.mymusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mymusic.databinding.ItemMusicBinding

class PlayListAdapter(private val playlist: ArrayList<Song>,
val onClick: (tittle: String)->Unit) :
    Adapter<PlayListAdapter.PlayListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        return PlayListViewHolder(
            ItemMusicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = playlist.size

    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.bind()
    }

    inner class PlayListViewHolder(private val binding: ItemMusicBinding) :
        ViewHolder(binding.root) {
        fun bind() {
            val item = playlist[adapterPosition]

            itemView.setOnClickListener {
                onClick(playlist[adapterPosition].name)
            }

            binding.first.text = item.name
            binding.index.text = item.number
            binding.minut.text = item.time
            binding.second.text = item.singer
        }

    }

}


