package it.piriottu.usecase.ui.scenes.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.piriottu.usecase.R
import it.piriottu.usecase.repositories.api.ApiRepositories
import it.piriottu.usecase.repositories.api.NetworkResponse
import it.piriottu.usecase.ui.scenes.main.sealed.PostsItem
import it.piriottu.usecase.utils.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

/**
 * Created by OverApp on 21/09/21.
 *  Visit https://www.overapp.com/
 */
class PostsFragmentViewModel : ViewModel() {

    //region UseCase
    sealed class UseCaseLiveData {
        data class ShowPosts(val items: MutableList<PostsItem>) : UseCaseLiveData()
        data class Error(val code: Int) : UseCaseLiveData()
    }
    //endregion UseCase

    //region LiveData
    val useCaseLiveData = MutableLiveData<Event<UseCaseLiveData>>()
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
                    //UItem List
                    val items: MutableList<PostsItem> = mutableListOf()
                    //Map response
                    this.data.forEach {

                        items.addAll(
                            mutableListOf(
                                //Title View
                                PostsItem.TitleUIItem(
                                    titleResId = getRandomTitle(),
                                    descriptionResId = getRandomMessage()
                                ),
                                //Image View
                                PostsItem.ImageUIItem(imageResId = getRandomImage()),
                                //Post View
                                PostsItem.PostUIItem(title = it.title, body = it.body)
                            )
                        )
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

    private fun getRandomTitle(): Int {
        return when (Random.nextInt(1, 3)) {
            2 -> R.string.title_post_two
            3 -> R.string.title_post_three
            //1 ->
            else -> {
                R.string.title_post_one
            }
        }
    }

    private fun getRandomMessage(): Int {
        return when (Random.nextInt(1, 3)) {
            2 -> R.string.message_post_two
            3 -> R.string.message_post_three
            //1 ->
            else -> {
                R.string.message_post_one
            }
        }
    }

    private fun getRandomImage(): Int {
        return when (Random.nextInt(1, 4)) {
            2 -> R.drawable.ic_image_two
            3 -> R.drawable.ic_image_three
            4 -> R.drawable.ic_image_four
            //1 ->
            else -> {
                R.drawable.ic_image_one
            }
        }
    }
    //endregion Private Methods
}





