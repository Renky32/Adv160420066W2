package com.example.adv160420066w2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.adv160420066w2.databinding.FragmentResultBinding
import kotlin.random.Random


class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding : FragmentResultBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if(arguments != null) {
            val Score =
                ResultFragmentArgs.fromBundle(requireArguments()).score
            binding.txtScore.text = "$Score"

        }
        binding.btnBack.setOnClickListener{
            val action = ResultFragmentDirections.actionMain()
            Navigation.findNavController(it).navigate(action)
        }
    }
}