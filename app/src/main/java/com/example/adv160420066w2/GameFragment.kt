package com.example.adv160420066w2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.adv160420066w2.databinding.FragmentGameBinding
import java.util.NavigableMap
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    var result: Int = 0
    var score : Int =10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val num1 = Random.nextInt(1,100)
        val num2 = Random.nextInt(1,100)
         result = num1+num2
        binding.txtQuestion.text = "$num1 + $num2 + ?";
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnResult.setOnClickListener {
            val answer = binding.txtAnswer.text.toString().toInt()
            if (result != answer) {
                score = 0
            }

            if (arguments != null) {
                val playerName =
                    GameFragmentArgs.fromBundle(requireArguments()).playerName
                binding.txtTurn.text = "$playerName's Turn"
            }

            val action = GameFragmentDirections.actionResult(score)
            Navigation.findNavController(it).navigate(action)
        }
    }

}