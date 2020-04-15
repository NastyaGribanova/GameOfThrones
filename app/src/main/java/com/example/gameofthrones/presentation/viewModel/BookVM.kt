package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.BookRepository
import com.example.gameofthrones.domain.model.Book
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BookVM(
    private val bookRepository: BookRepository
): ViewModel() {

    private val book: MutableLiveData<Book> by lazy { MutableLiveData<Book>() }
    val bookLD: LiveData<Book> = book
    private val books: MutableLiveData<List<Book>> by lazy { MutableLiveData<List<Book>>() }
    val booksLD: LiveData<List<Book>> = books

    fun book(name: String) {
        var result = bookRepository.bookByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                book.value = result
            }, {
                error ->
            })
    }

    fun allBooks() {
        var result = bookRepository.getBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                books.value = result
            }, {
                    error ->
            })
    }
}
