package com.chadmarchand.kutna.common.types

import kotlin.random.Random

typealias Id = Long
private typealias IdCompanion = Long.Companion

fun IdCompanion.random() = Random.nextLong()

val IdCompanion.DEFAULT_ID: Id
    get() = -1L
