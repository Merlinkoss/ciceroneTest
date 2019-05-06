package com.brightwave.ciceronetest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.brightwave.ciceronetest.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

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
        return root
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