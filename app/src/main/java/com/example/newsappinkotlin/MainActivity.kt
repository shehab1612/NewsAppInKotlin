package com.example.newsappinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.newsappinkotlin.R
import com.example.newsappinkotlin.ui.destinations.HeadlinesFragment
import com.example.newsappinkotlin.ui.destinations.ItemDetailsFragment
import com.example.newsappinkotlin.ui.destinations.SavedItemsFragment
import com.example.newsappinkotlin.ui.destinations.SplashFragment
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

        R.id.headlinesFragment.SetOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_container, headlines_fragment)
                addToBackStack(null)
                commit()
            }
        }

        R.id.savedItemsFragment.SetOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_container, savedItems_fragment)
                addToBackStack(null)
                commit()
            }
        }

        R.id.imageButton.SetOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_container, headlines_fragment)
                addToBackStack(null)
                commit()
            }
        }

        R.id.imageView2.SetOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_container, itemDetails_fragment)
                addToBackStack(null)
                commit()
            }
        }

        R.id.imageButton2.SetOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_container, savedItems_fragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}
