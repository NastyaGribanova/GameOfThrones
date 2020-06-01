package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.AllBooksModule
import com.example.gameofthrones.di.scope.AllBooksScope
import com.example.gameofthrones.presentation.recycler.book.BooksFragment
import dagger.Subcomponent

@AllBooksScope
@Subcomponent(modules = [AllBooksModule::class])
interface AllBooksComponent {

    fun inject(booksFragment: BooksFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): AllBooksComponent

    }
}
