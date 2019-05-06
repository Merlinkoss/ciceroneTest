package com.brightwave.ciceronetest

import android.app.Application
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router


class SampleApplication : Application() {
    private var cicerone: Cicerone<Router>? = null

    val navigatorHolder: NavigatorHolder
        get() = cicerone!!.navigatorHolder

    val router: Router
        get() = cicerone!!.router

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        initCicerone()
    }

    private fun initCicerone() {
        cicerone = Cicerone.create()
    }

    companion object {
        lateinit var INSTANCE: SampleApplication
    }
}