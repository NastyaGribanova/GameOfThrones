package com.example.gameofthrones.presentation.quiz

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.gameofthrones.R
import com.example.gameofthrones.di.AppInjector
import com.example.gameofthrones.presentation.viewModel.quiz.Level1VM
import javax.inject.Inject
import kotlin.random.Random

class Level1Fragment: Fragment() {

    lateinit var dialog: Dialog
    lateinit var dialogEnd: Dialog
    lateinit var navController: NavController

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var model: Level1VM? = null

    private var numAnswer1: Int = Random.nextInt(1, 10)
    private var numAnswer2: Int = Random.nextInt(1, 10)
    private var numQuestion: Int = Random.nextInt(1, 3)

    lateinit var anim: Animation
    lateinit var question: TextView
    lateinit var answer1: TextView
    lateinit var answer2: TextView

    lateinit var img_answer: ImageView
    var rightCount: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = activity?.let { Navigation.findNavController(it, R.id.nav_host_fragment) }!!
        return inflater.inflate(R.layout.fragment_level, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppInjector.plusLevel1Component().inject(this)
        initViewModel()
    }

    fun initViewModel(){
        val viewModel by lazy {
            ViewModelProvider(
                this,
                viewModelFactory
            ).get(Level1VM::class.java)
        }
        this.model = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        question = requireView().findViewById(R.id.tv_question)
        answer1 = requireView().findViewById(R.id.tv_answer)
        answer2 = requireView().findViewById(R.id.tv_answer2)
        img_answer = requireView().findViewById(R.id.img_answer)

        var progress = intArrayOf(R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
            R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10)

        anim = AnimationUtils.loadAnimation(context, R.anim.alpha)
        dialog()
        btnBack()
        level()
        model?.allHouses()

        answersAndQuestion(numAnswer1, numAnswer2, numQuestion)

        answer1.setOnTouchListener(View.OnTouchListener(
            fun(view: View?, motionEvent: MotionEvent): Boolean{
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        answer2.isEnabled = false
                        model?.checkAnswer(answer1.text.toString(), question.text.toString())
                        model?.rightAnswerLD?.observe(viewLifecycleOwner, Observer {
                            if (it == true){
                                img_answer.setImageDrawable(resources.getDrawable(R.drawable.img_true))
                            } else if (it == false) {
                                img_answer.setImageDrawable(resources.getDrawable(R.drawable.img_false))
                            }
                        })
                    }
                    MotionEvent.ACTION_UP -> {
                        var check: Int = 3
                        model?.checkAnswerNum(answer1.text.toString(), question.text.toString())
                        model?.rightAnswerNumLD?.observe(viewLifecycleOwner, Observer {
                            check = it
                        })

                        if (check==1){
                            if (rightCount < 10){
                                rightCount += 1
                            }
                        } else if (check==2) {
                            if (rightCount > 0) {
                                rightCount -= 1
                            }
                        }
                        for (i in 0..9){
                            var tv: TextView = requireView().findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points)
                        }
                        for (i in 0 until rightCount){
                            var tv: TextView = requireView().findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points_green)
                        }
                        if (rightCount == 10){
                            dialogEnd()
                        } else {
                            numAnswer1 = Random.nextInt(1, 10)
                            numAnswer2 = Random.nextInt(1, 10)
                            numQuestion = Random.nextInt(1,2)
                            answersAndQuestion(numAnswer1, numAnswer2, numQuestion)
                            img_answer.startAnimation(anim)
                            answer2.isEnabled = true
                        }
                    }
                }
                return true
            }
        ))

        answer2.setOnTouchListener(View.OnTouchListener(
            fun(view: View?, motionEvent: MotionEvent): Boolean{
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        answer1.isEnabled = false
                        model?.checkAnswer(answer2.text.toString(), question.text.toString())
                        model?.rightAnswerLD?.observe(viewLifecycleOwner, Observer {
                            if (it == true){
                                img_answer.setImageDrawable(resources.getDrawable(R.drawable.img_true))
                            } else if (it == false){
                                img_answer.setImageDrawable(resources.getDrawable(R.drawable.img_false))
                            }
                        })
                    }
                    MotionEvent.ACTION_UP -> {
                        var check: Int = 3
                        model?.checkAnswerNum(answer2.text.toString(), question.text.toString())
                        model?.rightAnswerNumLD?.observe(viewLifecycleOwner, Observer {
                            check = it
                        })
                        if (check==1){
                            if (rightCount < 10){
                                rightCount += 1
                            }
                        } else if (check==2) {
                            if (rightCount > 0) {
                                rightCount -= 1
                            }
                        }

                        for (i in 0..9){
                            var tv: TextView = requireView().findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points)
                        }
                        for (i in 0 until rightCount-1){
                            var tv: TextView = requireView().findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points_green)
                        }
                        if (rightCount == 10){
                            dialogEnd()
                        } else {
                            numAnswer1 = Random.nextInt(1, 10)
                            numAnswer2 = Random.nextInt(1, 10)
                            numQuestion = Random.nextInt(1,2)
                            answersAndQuestion(numAnswer1, numAnswer2, numQuestion)
                            img_answer.startAnimation(anim)
                            answer1.isEnabled = true
                        }
                    }
                }
                return true
            }
        ))
    }

    fun dialog(){
        dialog = Dialog(context)
        dialog.run {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.dialog_preview)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCancelable(false)
        }

        val btnCont: Button = dialog.findViewById(R.id.btn_continue)
        btnCont.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
        })

        var btnClose: TextView = dialog.findViewById(R.id.btn_close)
        btnClose.setOnClickListener() {
            navController.navigate(R.id.action_level1Fragment_to_quizFragment)
            dialog.dismiss()
        }
        dialog.show()
    }

    fun dialogEnd(){
        dialogEnd = Dialog(context)
        dialogEnd.run {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.dialog_end)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                             WindowManager.LayoutParams.MATCH_PARENT)
            setCancelable(false)
        }

        var btnClose: TextView = dialogEnd.findViewById(R.id.btn_close)
        btnClose.setOnClickListener() {
            navController.navigate(R.id.action_level1Fragment_to_quizFragment)
            dialogEnd.dismiss()
        }

        var btnContinue: TextView = dialogEnd.findViewById(R.id.btn_continue)
        btnContinue.setOnClickListener() {
            navController.navigate(R.id.action_level1Fragment_to_level2Fragment)
            dialogEnd.dismiss()
        }
        dialogEnd.show()
    }

    fun btnBack(){
        val btnBack: Button = requireView().findViewById(R.id.btn_back)
        btnBack.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.action_level1Fragment_to_quizFragment)
        })
    }

    fun level(){
        val text_level: TextView = requireView().findViewById(R.id.text_levels)
        text_level.setText(R.string.level1)
    }

    fun setQuestion(questionText: String){
        question.text = questionText
    }

    fun setAnswers(answer1Text: String, answer2Text: String){
        answer1.text = answer1Text
        answer2.text = answer2Text
    }

    fun answersAndQuestion(numAnswer1Random: Int, numAnswer2Random: Int, numQuestionRandom: Int){
        var numAnswer1Text: Int = numAnswer1Random
        var numAnswer2Text: Int = numAnswer2Random
        model?.housesLD?.observe(viewLifecycleOwner, Observer {
            val answer1Text: String = model?.getRandomHouse(numAnswer1Text, it)?.region.toString()
            val answer2Text: String = model?.getRandomHouse(numAnswer2Text, it)?.region.toString()
            if (answer1Text != answer2Text){
                setAnswers(answer1Text, answer2Text)
            } else {
                numAnswer1Text = Random.nextInt(1, 10)
                numAnswer2Text = Random.nextInt(1, 10)
                answersAndQuestion(numAnswer1Text, numAnswer2Text, numQuestionRandom)
            }
        })
        model?.housesLD?.observe(viewLifecycleOwner, Observer {
            if (numQuestionRandom == 1){
                setQuestion(model?.getRandomHouse(numAnswer1Text, it)?.name.toString())
            } else{
                setQuestion(model?.getRandomHouse(numAnswer2Text, it)?.name.toString())
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearlevel1Component()
    }
}
