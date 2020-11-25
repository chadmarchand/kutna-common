package com.chadmarchand.kutna.common.koin.demo

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.koin.test.KoinTest
import org.koin.test.inject

@ExtendWith(KoinDemoExtension::class)
class KoinDemoTest : KoinTest {
    @Test
    fun getServiceUsingKoin() {
        val demoService: DemoService by inject()
        demoService.runDemoService()

        assertThat(demoService).isNotNull()
    }
}
