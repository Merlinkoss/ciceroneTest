package com.brightwave.ciceronetest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.brightwave.ciceronetest.R
import com.brightwave.ciceronetest.SampleApplication
import com.brightwave.ciceronetest.Screens
import com.brightwave.ciceronetest.ui.fragments.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : BaseFragment() {
    override fun restoreFragment() {
        navView?.menu?.findItem(R.id.navigation_home)?.isChecked = true
        if (visibilityNavView)
            navView?.visibility = View.GONE
        else
            navView?.visibility = View.VISIBLE
    }

    private lateinit var homeViewModel: HomeViewModel
    private var navView: BottomNavigationView? = null
    private var visibilityNavView: Boolean = false

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        navView = activity!!.findViewById(R.id.nav_view)
        visibilityNavView = arguments?.getBoolean(HIDE_BOTTOM) ?: false
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentButton: Button = view.findViewById(R.id.fragmentBut)
        val fragmentButtonWithoutNav: Button = view.findViewById(R.id.fragmentNoBottom)

        fragmentButton.setOnClickListener {
            SampleApplication.INSTANCE.router.navigateTo(Screens.ForwardScreen(false))
        }

        fragmentButtonWithoutNav.setOnClickListener {
            SampleApplication.INSTANCE.router.navigateTo(Screens.ForwardScreen(true))
        }
    }

    companion object {
        private val HIDE_BOTTOM = "extra_bottom"

        fun getNewInstance(hideBottom: Boolean): HomeFragment {
            val fragment = HomeFragment()

            val arguments = Bundle()
            arguments.putBoolean(HIDE_BOTTOM, hideBottom)
            fragment.arguments = arguments

            return fragment
        }
    }
}