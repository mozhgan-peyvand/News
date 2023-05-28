package com.example.base.models


sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Exceptions) : Result<Nothing>()
}