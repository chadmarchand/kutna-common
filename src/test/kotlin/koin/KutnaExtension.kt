package com.chadmarchand.kutna.common.koin

import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.KoinContextHandler
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

open class KutnaExtension(
    private val koinModules: List<Module>
) : BeforeEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        stopKoinIfActive()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            modules(koinModules)
        }
    }

    private fun stopKoinIfActive() {
        val koin = GlobalContext.getOrNull()
        if (koin != null) {
            stopKoin()
        }
    }
}
