package com.brightwave.ciceronetest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brightwave.ciceronetest.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class ForwardFragment : Fragment() {
    var navView: BottomNavigationView? = null
    private var visibilityNavView: Boolean = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        navView = activity!!.findViewById(R.id.nav_view)

        return inflater.inflate(R.layout.fragment_forward, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        visibilityNavView = arguments?.getBoolean(HIDE_BOTTOM) ?: false

        if (visibilityNavView)
            navView?.visibility = View.GONE
        else
            navView?.visibility = View.VISIBLE
    }

    companion object {
        private val HIDE_BOTTOM = "extra_bottom"

        fun getNewInstance(hideBottom: Boolean): ForwardFragment {
            val fragment = ForwardFragment()

            val arguments = Bundle()
            arguments.putBoolean(HIDE_BOTTOM, hideBottom)
            fragment.arguments = arguments

            return fragment
        }
    }
}