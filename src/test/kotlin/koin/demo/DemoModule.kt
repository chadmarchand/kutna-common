package com.chadmarchand.kutna.common.koin.demo

import org.koin.dsl.module
import org.koin.experimental.builder.single

val demoModule = module(createdAtStart = true) {
    single<DemoService>()
}
