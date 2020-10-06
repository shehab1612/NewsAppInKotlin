package com.example.newsappinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsappinkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav_view.setupWithNavController(findNavController(R.id.nav_host_fragment_container))
        
        val headlines_fragment = HeadlinesFragment()
        val itemDetails_fragment = ItemDetailsFragment()
        val savedItems_fragment = SavedItemsFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment_container, headlines_fragment)
            addToBackStack(null)
            commit()
        }

        bottom_nav_view.headlinesFragment.SetOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_container, headlines_fragment)
                addToBackStack(null)
                commit()
            }
        }

        bottom_nav_view.savedItemsFragment.SetOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_container, savedItems_fragment)
                addToBackStack(null)
                commit()
            }
        }

        imageButton.SetOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_container, headlines_fragment)
                addToBackStack(null)
                commit()
            }
        }

        imageView2.SetOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_container, itemDetails_fragment)
                addToBackStack(null)
                commit()
            }
        }

        imageButton2.SetOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_container, savedItems_fragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}
