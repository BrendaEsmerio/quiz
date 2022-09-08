package esmerio.brenda.quiz


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import esmerio.brenda.quiz.databinding.ActivityMainBinding
private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val quizViewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) llamado")
        //setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "Tengo un QuizViewModel: $quizViewModel")


        binding.trueButtom.setOnClickListener { view: View ->
            /*val mySnackbar=Snackbar.make(view,R.string.incorrect_toast,Snackbar.LENGTH_LONG)
            mySnackbar.setBackgroundTint(resources.getColor(R.color.verde))
            mySnackbar.show()*/
            checkAnswer(true,view)
        }
        binding.falseButtom.setOnClickListener { view: View ->
            /*Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            ).show()*/
            /*val mySnackbar=Snackbar.make(view,R.string.incorrect_toast,Snackbar.LENGTH_LONG)
            mySnackbar.setBackgroundTint(resources.getColor(R.color.naranja))
            mySnackbar.show()*/
            checkAnswer(false,view)
        }

        binding.nextButton.setOnClickListener { view: View ->
           // Indice = (Indice + 1) % bancoPreguntas.size
            quizViewModel.siguentepregunta()
            updateQuestion()
        }
        updateQuestion()
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
    private fun updateQuestion() {
        //val preguntaTextResId=bancoPreguntas[Indice].TextoPregunta
        val preguntaTextResId = quizViewModel.currentQuestionText
        binding.questionText.setText(preguntaTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean,view:View) {
        //val correctAnswer = bancoPreguntas[Indice].respuesta
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        val colorBackgroud=if(userAnswer==correctAnswer){
            R.color.verde
        }else
            R.color.naranja
        val mySnackbar=Snackbar.make(view,messageResId,Snackbar.LENGTH_LONG)
        mySnackbar.setBackgroundTint(getColor(colorBackgroud))
        mySnackbar.show()
    }
}