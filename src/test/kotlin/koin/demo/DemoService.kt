package com.chadmarchand.kutna.common.koin.demo

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

internal class DemoService {
    fun runDemoService() {
        logger.info { "Running Demo Service" }
    }
}
