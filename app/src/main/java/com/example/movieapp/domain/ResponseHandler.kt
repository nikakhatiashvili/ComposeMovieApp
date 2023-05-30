package com.example.movieapp.domain

import retrofit2.Response

interface ResponseHandler {

    suspend fun <T> handleResponse(apicall: suspend() -> Response<T>): Resource<T>

    class Base: ResponseHandler {
        override suspend fun <T> handleResponse(apicall: suspend () -> Response<T>): Resource<T> {
            try {
                val response = apicall()
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    return Resource.Success(body)
                }

                return Resource.Error(response.errorBody().toString())

            } catch (e: Exception) {
                return Resource.Error(e.message.toString())
            }
        }

    }
}