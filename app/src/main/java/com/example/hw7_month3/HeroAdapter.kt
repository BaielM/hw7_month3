package com.example.hw7_month3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hw7_month3.databinding.ItemHeroesBinding
import kotlin.reflect.KFunction1

class HeroAdapter(private val heroList: ArrayList<Heroes>, private val onClick: (Heroes) -> Unit) :
    Adapter<HeroAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(
            ItemHeroesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(heroList[position])
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    inner class HeroViewHolder(private val binding: ItemHeroesBinding) : ViewHolder(binding.root) {
        fun bind(heroes: Heroes) {
            binding.tvName.text = heroes.name
            binding.tvState.text = heroes.state
            Glide.with(binding.imgPhotoHero).load(heroes.image).into(binding.imgPhotoHero)

            itemView.setOnClickListener {
                onClick(heroes)
            }
        }

    }
}
