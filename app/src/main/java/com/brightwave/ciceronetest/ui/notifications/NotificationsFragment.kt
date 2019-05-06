package com.brightwave.ciceronetest.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.brightwave.ciceronetest.R

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

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