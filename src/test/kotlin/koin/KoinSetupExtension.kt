package com.chadmarchand.koin

import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.koin.core.context.KoinContextHandler
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

open class KoinSetupExtension(private val koinModules: List<Module>) : BeforeEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        stopKoinIfActive()
        setupKoin(context)
    }

    private fun setupKoin(context: ExtensionContext) {
        startKoin {
            modules(koinModules)
        }
    }

    private fun stopKoinIfActive() {
        val koin = KoinContextHandler.getOrNull()
        if (koin != null) {
            stopKoin()
        }
    }
}
