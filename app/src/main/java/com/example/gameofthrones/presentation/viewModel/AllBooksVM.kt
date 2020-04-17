package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.AllBooksRepository
import com.example.gameofthrones.domain.model.Book
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AllBooksVM(
    private val allBooksRepository: AllBooksRepository
): ViewModel() {

    private val books: MutableLiveData<List<Book>> by lazy { MutableLiveData<List<Book>>() }
    val booksLD: LiveData<List<Book>> = books

    private val book: MutableLiveData<Book> by lazy { MutableLiveData<Book>() }
    val bookLD: LiveData<Book> = book

    private val errorBook: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val errorBookLD: LiveData<String> = errorBook

    fun allBooks() {
        var result = allBooksRepository.getBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                books.value = result
            }, {
                    error ->
                errorBook.value = "no such book"
            })
    }

    fun book(name: String) {
        var result = allBooksRepository.bookByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                book.value = result
            }, {
                    error ->
                errorBook.value = "no such book"
            })
    }
}
