package esmerio.brenda.quiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
class QuizViewModel : ViewModel() {
    init {
        Log.d(TAG, "Se creo el ViewModel")
    }
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "Se elimino el ViewModel")
    }
}