package com.example.android.common.basedi.basecoremodule

import android.util.Patterns
import org.koin.dsl.module
import java.util.regex.Pattern

val baseCoreModule = module {

    /**
     * 6/7/2020
     * single means singleton. Because many tests don't know about this android framework, we can mock it.
     * According to generics, Pattern is type parameter here.
     * The pair of angle brackets here are known as diamond notation.
     * We can read it like: Single of Pattern
     * Head over to below link to find the definition:
     * [koin definitions](https://doc.insert-koin.io/#/koin-core/definitions)
     * @author srdpatel
     * @since 1.0
     */
    single<Pattern> {
        Patterns.EMAIL_ADDRESS
    }
}