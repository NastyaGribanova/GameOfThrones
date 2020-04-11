package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.api.ApiBooks
import com.example.gameofthrones.data.api.ApiBooksItem
import com.example.gameofthrones.data.api.ApiFactory
import com.example.gameofthrones.data.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BookVM: ViewModel() {

    private var service: ApiService = ApiFactory.apiService

    val book: MutableLiveData<ApiBooksItem> by lazy { MutableLiveData<ApiBooksItem>() }
    val bookLD: LiveData<ApiBooksItem> = book
    val books: MutableLiveData<ApiBooks> by lazy { MutableLiveData<ApiBooks>() }
    val booksLD: LiveData<ApiBooks> = books

    fun book(name: String?) {
        var result = service.bookByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                book.value = result
            })
    }

    fun allBooks() {
        var result = service.getAllBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                books.value = result
            })
    }
}