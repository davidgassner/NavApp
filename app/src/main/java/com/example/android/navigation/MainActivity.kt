package com.example.android.navigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import androidx.navigation.findNavController
import com.example.android.navigation.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        val args = Bundle()
        args.putString("param1", "Selected")
        args.putString("param2", item.toString())
        findNavController(R.id.nav_host).navigate(R.id.action_to_params, args)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                findNavController(R.id.nav_host).navigate(R.id.main_dest)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                findNavController(R.id.nav_host).navigate(R.id.list_dest)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val args = Bundle()
                args.putString("param1", "Lydia")
                args.putString("param2", "Romero")
                findNavController(R.id.nav_host).navigate(R.id.action_global_params, args)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
