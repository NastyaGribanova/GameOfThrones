package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.ViewModelFactoryModule
import com.example.gameofthrones.di.scope.AllBooksScope
import com.example.gameofthrones.presentation.recycler.book.BooksFragment
import com.example.gameofthrones.presentation.viewModel.AllBooksVM
import dagger.Subcomponent

@AllBooksScope
@Subcomponent(modules = [AllBooksVM::class, ViewModelFactoryModule::class])
interface AllBooksComponent {

    fun inject(booksFragment: BooksFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): AllBooksComponent

    }
}
