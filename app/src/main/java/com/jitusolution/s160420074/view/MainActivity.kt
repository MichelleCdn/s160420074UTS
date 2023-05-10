package com.jitusolution.s160420074.view

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.android.volley.toolbox.Volley
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.databinding.ActivityMainBinding


//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    val volley by lazy { Volley.newRequestQueue(this) }
    private lateinit var binding: ActivityMainBinding

    val fragments = arrayListOf<Fragment>(
        HomeListFragment(),
        FavoriteFragment(),
        MenuFavFragment()
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val vp_main = view.findViewById<ViewPager2>(R.id.vp_main)
        val bn_main = view.findViewById<BottomNavigationView>(R.id.bn_main)
        val tb_main = view.findViewById<MaterialToolbar>(R.id.tb_main)
        val dw_main = view.findViewById<DrawerLayout>(R.id.dw_main)
        val nav_view = view.findViewById<NavigationView>(R.id.nav_view)


        val vpAdapter = HomeViewPageAdapter(this)
        vp_main.adapter = vpAdapter

        vp_main.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        bn_main.selectedItemId = R.id.itemHome
                    }
                    1 -> {
                        bn_main.selectedItemId = R.id.itemFavorite
                    }
                    2 -> {
                        bn_main.selectedItemId = R.id.itemMenuBS
                    }

                }
            }
        })

        bn_main.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemHome -> {
                    vp_main.setCurrentItem(0, true)
                }
                R.id.itemFavorite -> {
                    vp_main.setCurrentItem(1, true)
                }
                R.id.itemMenuBS -> {
                    vp_main.setCurrentItem(2, true)
                }

            }
            true
        }



        tb_main.setNavigationOnClickListener { dw_main.openDrawer(GravityCompat.START) }

        nav_view.setNavigationItemSelectedListener {
            bn_main.selectedItemId = it.itemId
            dw_main.closeDrawers()
            true
        }

    }




}