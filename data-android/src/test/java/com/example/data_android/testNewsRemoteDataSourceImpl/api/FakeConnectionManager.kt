package com.example.data_android.testNewsRemoteDataSourceImpl.api

import com.example.base.api.ConnectionManager

class FakeConnectionManager(
    private val isConnected: Boolean = true
) : ConnectionManager {
    override fun isConnected(): Boolean {
        return isConnected
    }
}