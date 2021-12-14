package com.arthacker.tablayoutandviewpager

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(mainActivity: MainActivity, private val listOfTitles: ArrayList<String>):FragmentStateAdapter(mainActivity) {
    override fun getItemCount(): Int {
       return listOfTitles.size
    }

    override fun createFragment(position: Int): Fragment {


        when(position){
            0-> return HomeFragment()
            1-> return NotificationFragment()
            2-> return ProfileFragment()
        }

        return HomeFragment()


    }


}
