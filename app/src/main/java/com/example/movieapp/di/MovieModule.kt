package com.example.movieapp.di

import com.example.movieapp.data.DetailRepositoryImpl
import com.example.movieapp.domain.Constants.BASE_URL
import com.example.movieapp.data.MoviesRepositoryImpl
import com.example.movieapp.domain.detail.DetailMovieUseCase
import com.example.movieapp.domain.detail.DetailRepository
import com.example.movieapp.domain.detail.DetailsService
import com.example.movieapp.domain.search.GetMoviesUseCase
import com.example.movieapp.domain.search.MoviesRepository
import com.example.movieapp.domain.search.SearchService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    @Provides
    @Singleton
    fun provideBaseRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            )
        ).client(okHttpClient).build()

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    @Provides
    @Singleton
    fun provideSearchService(baseRetrofit: Retrofit): SearchService =
        baseRetrofit.create(SearchService::class.java)

    @Provides
    fun provideSearchUseCases(repo: MoviesRepository): GetMoviesUseCase {
        return GetMoviesUseCase(repo)
    }

    @Provides
    fun provideMovieRepository(searchService: SearchService): MoviesRepository {
        return MoviesRepositoryImpl(searchService)
    }

    @Provides
    fun provideDetailRepository(detailsService: DetailsService):DetailRepository{
        return DetailRepositoryImpl(detailsService = detailsService)
    }

    @Provides
    fun provideDetailUseCases(repo: DetailRepository): DetailMovieUseCase {
        return DetailMovieUseCase(repo)
    }

    @Provides
    @Singleton
    fun provideDetailService(baseRetrofit: Retrofit): DetailsService =
        baseRetrofit.create(DetailsService::class.java)


}
