package com.example.movieapp.di

import com.example.movieapp.domain.Constants.BASE_URL
import com.example.movieapp.data.MoviesRepositoryImpl
import com.example.movieapp.domain.GetMoviesUseCase
import com.example.movieapp.domain.MoviesRepository
import com.example.movieapp.domain.SearchService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    @Singleton
    fun provideBaseRetrofit(): Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            )
        ).build()

    @Provides
    @Singleton
    fun provideSearchService(baseRetrofit: Retrofit): SearchService =
        baseRetrofit.create(SearchService::class.java)

    @Provides
    fun provideSearchUseCases(repo: MoviesRepository): GetMoviesUseCase {
        return GetMoviesUseCase(repo)
    }

    @Provides
    fun provideMovieRepository(searchService: SearchService):MoviesRepository {
        return MoviesRepositoryImpl(searchService)
    }
}
