package com.example.gameofthrones.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.AllBooksRepository
import com.example.gameofthrones.domain.model.Book
import com.example.gameofthrones.presentation.model.BookModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class AllBooksVM(
    private val allBooksRepository: AllBooksRepository
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val books: MutableLiveData<ArrayList<BookModel>> by lazy { MutableLiveData<ArrayList<BookModel>>() }
    val booksLD: LiveData<ArrayList<BookModel>> = books

    private val book: MutableLiveData<ArrayList<BookModel>> by lazy { MutableLiveData<ArrayList<BookModel>>() }
    val bookLD: LiveData<ArrayList<BookModel>> = book

    private val errorBook: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val errorBookLD: LiveData<String> = errorBook

    private fun mapBookToBookModel(book: ArrayList<Book>): ArrayList<BookModel> {
        val bookModel = ArrayList<BookModel>()
        for (books in book){
            bookModel.add(
                with(books){
                    BookModel(name, numberOfPages, publisher)
                }
            )
        }
        return bookModel
    }

    fun getBookByName(name: String) {
        compositeDisposable.add(
            allBooksRepository.bookByName(name)
                .map {
                    mapBookToBookModel(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    books.value = result
                },
                    { error ->
                        Log.e("ERROR11", error.toString())
                        errorSearchType(error)
                    })
        )
    }

    fun allBooks() {
        compositeDisposable.add(
            allBooksRepository.getBooks()
                .map {
                    mapBookToBookModel(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    books.value = result
                },
                    { error ->
                        errorBook.value = "no such book"
                    })
        )
    }

    private fun errorSearchType(error: Throwable) {
        when (error) {
            is java.lang.IllegalArgumentException -> {
                errorBook.value = "Enter the name"
            }
            is HttpException -> {
                errorBook.value = "Book not found"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
