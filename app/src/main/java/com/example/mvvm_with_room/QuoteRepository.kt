package com.example.mvvm_with_room

import androidx.lifecycle.LiveData

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>> {
        return quoteDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }
}