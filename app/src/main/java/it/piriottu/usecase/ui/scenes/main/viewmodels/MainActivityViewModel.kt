package it.piriottu.usecase.ui.scenes.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.piriottu.usecase.repositories.api.ApiRepositories
import it.piriottu.usecase.repositories.api.NetworkResponse
import it.piriottu.usecase.ui.scenes.main.uiitems.PostUIItem
import it.piriottu.usecase.utils.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by OverApp on 21/09/21.
 *  Visit https://www.overapp.com/
 */
class MainActivityViewModel : ViewModel() {

    //region UseCase
    sealed class UseCaseLiveData {
        data class ShowPosts(val items: MutableList<PostUIItem>) : UseCaseLiveData()
        data class Error(val code: Int) : UseCaseLiveData()
    }
    //endregion UseCase

    //region LiveData
    val useCaseLiveData = MutableLiveData<Event<UseCaseLiveData>>()
    private val items: MutableList<PostUIItem> = mutableListOf()
    //endregion LiveData

    //region Public Methods

    fun getPosts() {
        viewModelScope.launch {
            callPosts()
        }
    }

    //endregion Public Methods
    //region Private Methods
    private suspend fun callPosts() {
        withContext(Dispatchers.IO) {
            ApiRepositories.getAllPosts()
        }.apply {
            when (this) {
                is NetworkResponse.Success -> {

                    //Map response
                    this.data.forEach {
                        items.add(PostUIItem(title = it.title, body = it.body))
                    }
                    //Send map
                    useCaseLiveData.value =
                        Event(UseCaseLiveData.ShowPosts(items))
                }
                is NetworkResponse.Error -> useCaseLiveData.value =
                    Event(UseCaseLiveData.Error(this.code))
            }
        }
    }
    //endregion Private Methods
}





