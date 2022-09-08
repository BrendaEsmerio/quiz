package esmerio.brenda.quiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
class QuizViewModel (private val savedStateHandle: SavedStateHandle): ViewModel() {
   /* init {
        Log.d(TAG, "Se creo el ViewModel")
    }
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "Se elimino el ViewModel")
    }*/
    private val bancoPreguntas=listOf(
        preguntas(R.string.pregunta_Moscu,true),
        preguntas(R.string.pregunta_America,false),
        preguntas(R.string.pregunta_Brasil,false),
        preguntas(R.string.pregunta_India,false),
        preguntas(R.string.pregunta_Panama,false),
        preguntas(R.string.pregunta_Portugal,false)


    )
    private var Indice
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = bancoPreguntas[Indice].respuesta
    val currentQuestionText: Int
        get() = bancoPreguntas[Indice].TextoPregunta
    fun siguentepregunta() {
        Indice = (Indice + 1) % bancoPreguntas.size
    }
}