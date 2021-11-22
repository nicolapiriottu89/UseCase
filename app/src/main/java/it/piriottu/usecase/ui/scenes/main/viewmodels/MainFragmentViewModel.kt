package it.piriottu.usecase.ui.scenes.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import it.piriottu.usecase.utils.Event

/**
 * Created by OverApp on 21/09/21.
 *  Visit https://www.overapp.com/
 */
class MainFragmentViewModel : ViewModel() {

    //region UseCase
    sealed class UseCaseLiveData {
        object GoToPostsFragment : UseCaseLiveData()
        object GoToErrorFragment : UseCaseLiveData()
    }
    //endregion UseCase

    //region LiveData
    val useCaseLiveData = MutableLiveData<Event<UseCaseLiveData>>()

    //endregion LiveData

    //region Public Methods
    fun onPostsClicked() {
        useCaseLiveData.value = Event(UseCaseLiveData.GoToPostsFragment)
    }

    fun onErrorClicked() {
        useCaseLiveData.value = Event(UseCaseLiveData.GoToErrorFragment)
    }

    //endregion Private Methods
}





