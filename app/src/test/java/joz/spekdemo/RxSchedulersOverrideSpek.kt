package com.gox

import org.jetbrains.spek.api.Spek
import rx.plugins.RxJavaHooks
import rx.schedulers.Schedulers


object RxSchedulersOverrideSpek :Spek({

    beforeGroup {
        RxJavaHooks.setOnIOScheduler { current -> Schedulers.immediate() }
        RxJavaHooks.setOnComputationScheduler { current -> Schedulers.immediate() }
        RxJavaHooks.setOnNewThreadScheduler { current -> Schedulers.immediate() }

    }

})