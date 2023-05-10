package com.jitusolution.s160420074.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeViewPageAdapter(fragment: FragmentActivity) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeListFragment()
            }
            1 -> {
                FavListFragment()
            }
            else -> {
                MenuFavFragment()
            }

        }
    }
}
