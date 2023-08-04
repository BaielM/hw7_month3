package com.example.hw7_month3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.hw7_month3.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var navArgs: SecondFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val result = arguments?.getSerializable("naruto") as Heroes


        arguments?.let {
            navArgs = SecondFragmentArgs.fromBundle(it)
        }
        binding.tvName.text = navArgs.naruto.name
        binding.tvState.text = navArgs.naruto.state
        Glide.with(binding.imgPhotoHero).load(navArgs.naruto.image).into(binding.imgPhotoHero)

    }
}
//vvfvdvv