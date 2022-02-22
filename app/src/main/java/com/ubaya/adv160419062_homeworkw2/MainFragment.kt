package com.ubaya.adv160419062_homeworkw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    var randNumber1 = (1..100).random()
    var randNumber2 = (1..100).random()
    var answer = randNumber1 + randNumber2
    var playerScores = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textNumber.text = randNumber1.toString()
        textNumber2.text = randNumber2.toString()
        buttonSubmit.setOnClickListener {
            var playerAnswer : Int = Integer.parseInt(textAnswer.getText().toString());
            if(playerAnswer == answer){
                playerScores += 1
                randNumber1 = (1..100).random()
                randNumber2 = (1..100).random()
                answer = randNumber1 + randNumber2
                textNumber.text = randNumber1.toString()
                textNumber2.text = randNumber2.toString()

            }
            else if(playerAnswer != answer){
                //get action
                val action = MainFragmentDirections.actionMainFragmentToResultFragment(playerScores = playerScores)
                //run action
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}

