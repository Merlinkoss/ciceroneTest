package com.brightwave.ciceronetest.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.brightwave.ciceronetest.R
import com.brightwave.ciceronetest.ui.fragments.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NotificationsFragment : BaseFragment() {
    override fun restoreFragment() {
        navView?.menu?.findItem(R.id.navigation_notifications)?.isChecked = true
        if (visibilityNavView) {
            navView?.visibility = View.GONE
        } else
            navView?.visibility = View.VISIBLE
    }
    private lateinit var notificationsViewModel: NotificationsViewModel
    var navView: BottomNavigationView? = null
    var visibilityNavView: Boolean = false



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        navView = activity!!.findViewById(R.id.nav_view)
        visibilityNavView = arguments?.getBoolean(HIDE_BOTTOM) ?: false

        return root
    }

    companion object {
        private val HIDE_BOTTOM = "extra_bottom"

        fun getNewInstance(hideBottom: Boolean): NotificationsFragment {
            val fragment = NotificationsFragment()

            val arguments = Bundle()
            arguments.putBoolean(HIDE_BOTTOM, hideBottom)
            fragment.arguments = arguments

            return fragment
        }
    }
}