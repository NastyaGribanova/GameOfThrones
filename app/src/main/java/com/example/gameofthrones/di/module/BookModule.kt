package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.BookRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.BookScope
import com.example.gameofthrones.domain.interfaces.BookRepository
import com.example.gameofthrones.presentation.viewModel.BookVM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class BookModule {

    @BookScope
    @Provides
    fun provideBookRepository(bookRepository: BookRepositoryImpl)
            : BookRepository = bookRepository

    @BookScope
    @Provides
    @IntoMap
    @ViewModelKey(BookVM::class)
    fun provideBookViewModel(bookRepository: BookRepositoryImpl): ViewModel {
        return BookVM(
            bookRepository
        )
    }
}