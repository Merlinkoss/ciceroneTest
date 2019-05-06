package com.brightwave.ciceronetest

import androidx.fragment.app.Fragment
import com.brightwave.ciceronetest.ui.dashboard.DashboardFragment
import com.brightwave.ciceronetest.ui.fragments.ForwardFragment
import com.brightwave.ciceronetest.ui.home.HomeFragment
import com.brightwave.ciceronetest.ui.notifications.NotificationsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen


object Screens {
    class ForwardScreen(private val hideBottom: Boolean) : SupportAppScreen() {

        override fun getFragment(): Fragment {
            return ForwardFragment.getNewInstance(hideBottom)
        }
    }

    class HomeScreen(private val hideBottom: Boolean) : SupportAppScreen() {

        override fun getFragment(): Fragment {
            return HomeFragment.getNewInstance(hideBottom)
        }
    }

    class NotifactionScreen(private val hideBottom: Boolean) : SupportAppScreen() {

        override fun getFragment(): Fragment {
            return NotificationsFragment.getNewInstance(hideBottom)
        }
    }

    class DashboardScreen(private val hideBottom: Boolean) : SupportAppScreen() {

        override fun getFragment(): Fragment {
            return DashboardFragment.getNewInstance(hideBottom)
        }
    }

}