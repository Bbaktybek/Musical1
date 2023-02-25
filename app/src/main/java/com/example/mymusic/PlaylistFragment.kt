package com.example.mymusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymusic.databinding.FragmentPlaylistBinding


class PlaylistFragment : Fragment() {

    private lateinit var binding: FragmentPlaylistBinding
    private lateinit var playlist: ArrayList<Song>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaylistBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = PlayListAdapter(playlist, this::onClick)
        binding.recyclerView.adapter = adapter
    }

    private fun loadData() {
        playlist = ArrayList<Song>()
        playlist.add(Song("1","2:28","Вороны","Xcho"))
        playlist.add(Song("2","3:43","Дай мне огня","Xcho"))
        playlist.add(Song("3","1:49","Гангстер","Xcho"))
        playlist.add(Song("4","2:00","Листок","Xcho"))
        playlist.add(Song("5","3:00","Лондон","Xcho"))
        playlist.add(Song("6","4:11","Майка","Xcho"))
        playlist.add(Song("7","1:45","Океан","Xcho"))
        playlist.add(Song("8","1:58","Налей","Xcho"))
        playlist.add(Song("9","2:24","Мотив","Xcho"))
        playlist.add(Song("10","3:00","Забираю Души","Xcho"))

    }

    private fun onClick(tittle: String){
        val bundle = Bundle()
        bundle.putString("key",tittle)
        val infoFragment = InfoFragment()
        infoFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, infoFragment).addToBackStack(null).commit()
    }


}