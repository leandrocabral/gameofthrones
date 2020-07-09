package com.leandroid.gameofthrones.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.leandroid.domain.Character
import com.leandroid.gameofthrones.R
import com.leandroid.gameofthrones.databinding.CharacterItemBinding
import com.leandroid.gameofthrones.widget.CommomCardView

class CharacterAdapter(var characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, i: Int) {
        holder.characterItemBinding.character = characters[i]
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): CharacterViewHolder =
        CharacterViewHolder(
            DataBindingUtil.inflate<CharacterItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.character_item,
                parent,
                false
            )
        )

    class CharacterViewHolder(val characterItemBinding: CharacterItemBinding)
        : RecyclerView.ViewHolder(characterItemBinding.root)

}