package com.brightwave.ciceronetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command


class MainActivity : AppCompatActivity() {

    private val navigator = object : SupportAppNavigator(this, R.id.nav_host_fragment) {
        override fun applyCommands(commands: Array<Command>) {
            super.applyCommands(commands)
            supportFragmentManager.executePendingTransactions()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.navigation_home -> SampleApplication.INSTANCE.router.navigateTo(Screens.HomeScreen(false))
                R.id.navigation_dashboard -> SampleApplication.INSTANCE.router.navigateTo(Screens.DashboardScreen(false))
                R.id.navigation_notifications -> SampleApplication.INSTANCE.router.navigateTo(Screens.NotifactionScreen(false))
            }

            return@setOnNavigationItemSelectedListener true
        }

        SampleApplication.INSTANCE.router.replaceScreen(Screens.HomeScreen(false))
    }

    override fun onResume() {
        super.onResume()
        SampleApplication.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        SampleApplication.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        SampleApplication.INSTANCE.router.exit()
    }
}
