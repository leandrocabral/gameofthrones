package com.leandroid.gameofthrones.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.viewModel
import com.leandroid.gameofthrones.R
import com.leandroid.gameofthrones.databinding.CharacterFragmentBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandroid.domain.Character

class CharacterFragment : Fragment() {

    private lateinit var binding: CharacterFragmentBinding
    private val viewModel: CharacterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.character_fragment, container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadCharacter()

        viewModel.charactersLiveData.observe(viewLifecycleOwner, Observer { characters ->
            mountList(characters)
        })

    }

    private fun mountList(characters: List<Character>) {
        binding.recCharacter.setHasFixedSize(true)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        binding.recCharacter.layoutManager = llm

        val adapter = CharacterAdapter(characters)
        binding.recCharacter.adapter = adapter
    }
}