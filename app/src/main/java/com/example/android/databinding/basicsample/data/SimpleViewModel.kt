package com.example.android.databinding.basicsample.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * A simple VM for [com.example.android.databinding.basicsample.ui.EdwinActivity].
 */
class SimpleViewModel : ViewModel() {
    private val _name = MutableLiveData("Edwin")
    private val _lastName = MutableLiveData("Peraza")
    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes


    val popularity: LiveData<Popularity> = Transformations.map(_likes) {
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }

    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}
