package com.example.hw7_month3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw7_month3.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: HeroAdapter
    private var heroList = arrayListOf<Heroes>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HeroAdapter(heroList, this::onClick)

        heroList.add(Heroes("https://images.immediate.co.uk/production/volatile/sites/3/2023/04/naruto-762b09d.jpg?resize=768,574", "alive", "Naruto"))
        heroList.add(Heroes("https://i.pinimg.com/1200x/41/12/42/411242aa2860d0c4775da952d4ee9292.jpg", "alive", "Saske"))
        heroList.add(Heroes("https://static.wikia.nocookie.net/narutofans/images/e/ec/Sakura-Haruno-naruto-shippuuden-20578256-512-288.jpg/revision/latest/scale-to-width-down/512?cb=20111226190627&path-prefix=pt", "alive", "Sakura"))
        heroList.add(Heroes("https://citaty.info/files/portraits/screenshot_7_19.jpg", "alive", "Kakashi"))
        heroList.add(Heroes("https://upload.wikimedia.org/wikipedia/tr/c/c9/Jiraiya_main.jpg", "death", "Jiraiya"))

        binding.rvRickyAndMorty.adapter = adapter
    }

    private fun onClick(heroes: Heroes) {
        findNavController().navigate(R.id.secondFragment, bundleOf("naruto" to heroes))
    }
}