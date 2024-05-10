package it.piriottu.usecase.ui.scenes.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.piriottu.usecase.interactors.GetPhotosResponse
import it.piriottu.usecase.repositories.api.ApiRepositories
import it.piriottu.usecase.repositories.api.NetworkResponse
import it.piriottu.usecase.ui.scenes.main.sealed.PostItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel : ViewModel() {

    //TODO WIP
    private val useCase = GetPhotosResponse(repository = ApiRepositories)

    //UIItem
    val postLiveData: MutableLiveData<MutableList<PostItem>> = MutableLiveData()

    val errorAPILiveData: MutableLiveData<Boolean> = MutableLiveData()
    //region Public Methods

    fun showPost(isShowSimplePost: Boolean) {
        if (isShowSimplePost) {
            getSimple()
        } else {
            getFeature()
        }
    }

    private fun getSimple() {
        viewModelScope.launch {
            callSimplePhoto()
        }
    }

    private fun getFeature() {
        viewModelScope.launch {
            callFeaturePhoto()
        }
    }

    private suspend fun callFeaturePhoto() {
        withContext(Dispatchers.IO) {
            useCase.getPhotoByUserId(1)
        }.apply {
            when (this) {
                is NetworkResponse.Success -> {
                    //UItem List
                    val items: MutableList<PostItem> = mutableListOf()

                    val response = this.data

                    val images =
                        mutableListOf(response.url, response.url, response.url, response.url)

                    //Map response
                    items.addAll(
                        mutableListOf(
                            //Title View
                            PostItem.TitleUIItem(
                                title = response.title,
                                subtitle = response.title
                            ),
                            //Description View
                            PostItem.DescriptionUIItem(
                                title = response.title,
                                body = response.title
                            ),
                            //Gallery View
                            PostItem.GalleryUIItem(
                                title = response.title,
                                imagesUrl = images
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

    //endregion Public Methods
    //region Private Methods
    private suspend fun callSimplePhoto() {
        withContext(Dispatchers.IO) {
            useCase.getPhotoByUserId(1)
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
                                title = response.title,
                                subtitle = response.title
                            ),

                            //Image View
                            PostItem.ImageUIItem(imageUrl = response.url),

                            //Post View
                            PostItem.DescriptionUIItem(
                                title = response.title,
                                body = response.title
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