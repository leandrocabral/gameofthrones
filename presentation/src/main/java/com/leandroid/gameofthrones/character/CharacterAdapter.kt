package com.leandroid.gameofthrones.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandroid.domain.Character
import com.leandroid.gameofthrones.R
import com.leandroid.gameofthrones.widget.CommomCardView

class CharacterAdapter(var characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(charactersViewHolder: CharacterViewHolder, i: Int) {
        val card = charactersViewHolder.vCommomCardView
        card.setName(characters[i].name)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CharacterViewHolder {
        val itemView: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.character_item, viewGroup, false)
        return CharacterViewHolder(itemView)
    }

    class CharacterViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vCommomCardView: CommomCardView

        init {
            vCommomCardView = v.findViewById(R.id.ccv_character)
        }
    }
}