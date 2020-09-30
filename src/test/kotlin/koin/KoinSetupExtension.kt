package koin

import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.koin.core.context.KoinContextHandler
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module


class KoinSetupExtension(private val koinModule: Module) : BeforeEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        stopKoinIfActive()
        setupKoin(context)
    }

    private fun setupKoin(context: ExtensionContext) {
        startKoin {
            modules(listOf(koinModule))
        }
    }

    private fun stopKoinIfActive() {
        val koin = KoinContextHandler.getOrNull()
        if (koin != null) {
            stopKoin()
        }
    }
}
