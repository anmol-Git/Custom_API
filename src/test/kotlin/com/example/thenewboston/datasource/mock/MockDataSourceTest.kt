package com.example.thenewboston.datasource.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MockDataSourceTest{
    //plain old java object
    private val mockDataSource =MockDataSource()

    @Test
    fun `should provide a list or collection of the banks`(){
             //given

             //when
        val banks =mockDataSource.retrieveBanks()
             //then
        Assertions.assertThat(banks).isNotEmpty
        Assertions.assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data `(){
        val banks =mockDataSource.retrieveBanks()
        Assertions.assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        Assertions.assertThat(banks).anyMatch { it.trust!=0.0}
        Assertions.assertThat(banks).allMatch { it.transactionFee!=0 }
    }
}