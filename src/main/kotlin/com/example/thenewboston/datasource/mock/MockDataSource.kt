package com.example.thenewboston.datasource.mock

import com.example.thenewboston.datasource.BankDataSource
import com.example.thenewboston.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class MockDataSource :BankDataSource {
    val banks = mutableListOf(
            Bank("1234",0.4,11),
            Bank("1203",17.32,41),
            Bank("1634",1.61,91))
    override fun retrieveBanks(): Collection<Bank> =banks
    override fun retrieveBank(accountNumber: String): Bank {
        return banks.firstOrNull() { it.accountNumber==accountNumber }
                ?:throw NoSuchElementException("could not find bank with $accountNumber")
    }

    override fun createBank(bank: Bank): Bank {
        if (banks.any{it.accountNumber==bank.accountNumber}){
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exist.")
        }
        banks.add(bank)
        return bank
    }
}