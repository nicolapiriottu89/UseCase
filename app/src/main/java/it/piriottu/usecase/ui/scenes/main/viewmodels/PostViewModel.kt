package it.piriottu.usecase.ui.scenes.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.piriottu.usecase.repositories.api.ApiRepositories
import it.piriottu.usecase.repositories.api.NetworkResponse
import it.piriottu.usecase.ui.scenes.main.sealed.PostItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by OverApp on 21/09/21.
 *  Visit https://www.overapp.com/
 */
class PostViewModel : ViewModel() {

    val postLiveData: MutableLiveData<MutableList<PostItem>> = MutableLiveData()
    val errorAPILiveData: MutableLiveData<Boolean> = MutableLiveData()
    //region Public Methods


    fun showPost(isShowSimplePost: Boolean) {
        if (isShowSimplePost) {
            getSimplePost()
        } else {
            getFeaturePost()
        }
    }

    private fun getSimplePost() {
        viewModelScope.launch {
            callSimplePost()
        }
    }

    private fun getFeaturePost() {
        viewModelScope.launch {
            callFeaturePost()
        }
    }

    //endregion Public Methods
    //region Private Methods
    private suspend fun callSimplePost() {
        withContext(Dispatchers.IO) {
            ApiRepositories.getSimplePost()
        }.apply {
            when (this) {
                is NetworkResponse.Success -> {
                    //UItem List
                    val items: MutableList<PostItem> = mutableListOf()

                    val response = this.data

                    //Map response
                    items.addAll(
                        mutableListOf(
                            //Title View
                            PostItem.TitleUIItem(
                                title = response.title.title,
                                subtitle = response.title.subtitle
                            ),
                            //Image View
                            PostItem.ImageUIItem(imageUrl = response.image),
                            //Post View
                            PostItem.DescriptionUIItem(
                                title = response.description.title,
                                body = response.description.body
                            )
                        )
                    )
                    //notify
                    postLiveData.value = items
                }
                is NetworkResponse.Error -> {
                    //notify
                    errorAPILiveData.value = true
                }
            }
        }
    }

    private suspend fun callFeaturePost() {
        withContext(Dispatchers.IO) {
            ApiRepositories.getFeaturePost()
        }.apply {
            when (this) {
                is NetworkResponse.Success -> {
                    //UItem List
                    val items: MutableList<PostItem> = mutableListOf()

                    val response = this.data

                    //Map response
                    items.addAll(
                        mutableListOf(
                            //Title View
                            PostItem.TitleUIItem(
                                title = response.title.title,
                                subtitle = response.subtitle.subtitle
                            ),
                            //Description View
                            PostItem.DescriptionUIItem(
                                title = response.description.title,
                                body = response.description.partOne + response.description.partTwo + response.description.partThree
                            ),
                            //Gallery View
                            PostItem.GalleryUIItem(
                                title = response.gallery.label,
                                imagesUrl = response.gallery.images
                            )
                        )
                    )
                    //notify
                    postLiveData.value = items
                }
                is NetworkResponse.Error -> {
                    //notify
                    errorAPILiveData.value = true
                }
            }
        }
    }
    //endregion Private Methods
}