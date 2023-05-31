package com.example.data.android.testNewsRemoteDataSourceImpl.api

import com.example.base.api.ConnectionManager

class FakeConnectionManager(
    private val isConnected: Boolean = true
) : ConnectionManager {
    override fun isConnected(): Boolean {
        return isConnected
    }
}