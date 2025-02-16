package com.example.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.music.databinding.FragmentPlayerBinding

class PlayerFragment : Fragment() {
    private var _binding: FragmentPlayerBinding? = null
    private val binding get() = _binding!!

    private val playerViewModel: PlayerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playerViewModel.currentTrack.observe(viewLifecycleOwner) { track ->
            track?.let {
                binding.trackTitle.text = it.title
                binding.artistName.text = it.artist

                Glide.with(requireContext())
                    .load(it.coverUrl)
                    .placeholder(R.drawable.ic_music_placeholder)
                    .error(R.drawable.ic_music_placeholder)
                    .into(binding.albumCover)
            }
        }

        binding.playButton.setOnClickListener {
            playerViewModel.currentTrack.value?.let {
            }
        }

        binding.pauseButton.setOnClickListener {
        }    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}