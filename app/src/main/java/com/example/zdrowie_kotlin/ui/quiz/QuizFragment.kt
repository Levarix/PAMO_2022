package com.example.zdrowie_kotlin.ui.quiz

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zdrowie_kotlin.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {
    var tvQueConter: TextView? = null
    var tvQue: TextView? = null
    var btOpt1: Button? = null
    var btOpt2: Button? = null
    var btOpt3: Button? = null
    var btOpt4: Button? = null
    var queList = ArrayList<QuestionClass>()
    var conter = 0
    var tm: CountDownTimer? = null
    private var binding: FragmentQuizBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        val root: View = binding!!.getRoot()
        tvQue = binding!!.tvQue
        tvQueConter = binding!!.tvQueConter
        btOpt1 = binding!!.btOpt1
        btOpt2 = binding!!.btOpt2
        btOpt3 = binding!!.btOpt3
        btOpt4 = binding!!.btOpt4
        queList.add(
            QuestionClass(
                "Ile wynosi prawidłowy poziom cholesterolu?",
                "Do 200 mg/dl",
                "Do 300 mg/dl",
                "Do 500 mg/dl",
                "Do 100 mg/dl",
                "Do 200 mg/dl"
            )
        )
        queList.add(
            QuestionClass(
                "Które z wymienionych owoców zawiera najwięcej witaminy C w 100g?",
                "Cytryna",
                "Śliwki",
                "Czarne porzeczki",
                "Owoce dzikiej róży",
                "Owoce dzikiej róży"
            )
        )
        queList.add(
            QuestionClass(
                "Ryboflawina to inna nazwa której witaminy?",
                "Witamina K",
                "Witaminy E",
                "Witaminy B2",
                "Witaminy B12",
                "Witaminy B2"
            )
        )
        queList.add(
            QuestionClass(
                "Wiesz ile kości średnio znajduje się w szkielecie dorosłego człowieka?",
                "206",
                "340",
                "144",
                "290",
                "206"
            )
        )
        queList.add(
            QuestionClass(
                "Który z hormonów odpowiedzialny jest za regulowanie rytmu dobowego u człowieka (snu)? ",
                "Prolaktyna",
                "Melatonina",
                "Insulina",
                "Kortyzol",
                "Melatonina"
            )
        )
        queList.add(
            QuestionClass(
                "Ile litrów krwi średnio znajduje się w organizmie dorosłego człowieka?",
                "2-3 litry",
                "około 9 litrów",
                "5-6 litrów",
                "1-2 litry",
                "5-6 litrów"
            )
        )
        conter = 0
        loadQuetions(conter)
        return root
    }

    fun loadQuetions(n: Int) {
        val q = queList[n]
        tvQueConter!!.text = (n + 1).toString() + "/" + queList.size
        tvQue!!.text = "#" + (n + 1) + " " + q.que
        btOpt1!!.text = "" + q.opt1
        btOpt2!!.text = "" + q.opt2
        btOpt3!!.text = "" + q.opt3
        btOpt4!!.text = "" + q.opt4
        btOpt1!!.setOnClickListener {
            if (btOpt1!!.text == q.rightOpt) {
                Toast.makeText(activity, "Correct Answer", Toast.LENGTH_SHORT).show()
                if (conter < queList.size - 1) {
                    conter++
                    loadQuetions(conter)
                } else {
                    Toast.makeText(activity, "All Que Completed!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(activity, "Wrong Answer", Toast.LENGTH_SHORT).show()
            }
        }
        btOpt2!!.setOnClickListener {
            if (btOpt2!!.text == q.rightOpt) {
                Toast.makeText(context, "Correct Answer", Toast.LENGTH_SHORT).show()
                if (conter < queList.size - 1) {
                    conter++
                    loadQuetions(conter)
                } else {
                    Toast.makeText(context, "All Que Completed!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Wrong Answer", Toast.LENGTH_SHORT).show()
            }
        }
        btOpt3!!.setOnClickListener {
            if (btOpt3!!.text == q.rightOpt) {
                Toast.makeText(activity, "Correct Answer", Toast.LENGTH_SHORT).show()
                if (conter < queList.size - 1) {
                    conter++
                    loadQuetions(conter)
                } else {
                    Toast.makeText(activity, "All Que Completed!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(activity, "Wrong Answer", Toast.LENGTH_SHORT).show()
            }
        }
        btOpt4!!.setOnClickListener {
            if (btOpt4!!.text == q.rightOpt) {
                Toast.makeText(context, "Correct Answer", Toast.LENGTH_SHORT).show()
                if (conter < queList.size - 1) {
                    conter++
                    loadQuetions(conter)
                } else {
                    Toast.makeText(context, "All Que Completed!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Wrong Answer", Toast.LENGTH_SHORT).show()
            }
        }
    }
}