package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AllBooksRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.AllBooksScope
import com.example.gameofthrones.domain.interfaces.AllBooksRepository
import com.example.gameofthrones.presentation.viewModel.AllBooksVM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class AllBooksModule {

    @AllBooksScope
    @Provides
    fun provideBooksRepository(booksRepository: AllBooksRepositoryImpl)
            : AllBooksRepository = booksRepository

    @AllBooksScope
    @Provides
    @IntoMap
    @ViewModelKey(AllBooksVM::class)
    fun provideBooksViewModel(booksRepository: AllBooksRepositoryImpl): ViewModel {
        return AllBooksVM(
            booksRepository
        )
    }
}
