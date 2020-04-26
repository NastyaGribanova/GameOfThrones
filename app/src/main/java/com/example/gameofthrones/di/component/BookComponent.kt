package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.BookModule
import com.example.gameofthrones.di.module.ViewModelFactoryModule
import com.example.gameofthrones.di.scope.BookScope
import com.example.gameofthrones.presentation.fragment.BookFragment
import com.example.gameofthrones.presentation.viewModel.BookVM
import dagger.Subcomponent

@BookScope
@Subcomponent(modules = [BookModule::class])
interface BookComponent {

    fun inject(bookFragment: BookFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): BookComponent

    }
}
