package com.example.gootaxtestproject.di

import com.example.gootaxtestproject.data.network.common.Common.gootaxService
import com.example.gootaxtestproject.presentation.MainViewModel
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@OptIn(FlowPreview::class)
val viewModel = module {
    viewModel {
        MainViewModel(get())
    }
}

val networkModel = module {
    single {
        gootaxService
    }
}