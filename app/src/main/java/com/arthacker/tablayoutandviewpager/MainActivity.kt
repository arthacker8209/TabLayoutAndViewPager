package com.arthacker.tablayoutandviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.arthacker.tablayoutandviewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var googleTabLayout: TabLayout
    private lateinit var badgeTabLayout: TabLayout
    private lateinit var iconBadgeTabLayout: TabLayout
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    private val listOfTitles = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayout= findViewById(R.id.tab_layout)
        googleTabLayout= findViewById(R.id.google_tab_layout)
        badgeTabLayout= findViewById(R.id.badge_tab_layout)
        iconBadgeTabLayout= findViewById(R.id.icon_badge_tab_layout)
        viewPager = findViewById(R.id.view_pager)


        loadTitles()
        setUpBadgeForTabLayout()
        setUpIconWithBadgeForTabLayout()
        setUpViewPagerWithTabLayout()
//        setUpPagerTabLayout()
        addTabLayoutMediator()
       // setUpPagerTabLayout()





    }


   private fun loadTitles(){
        listOfTitles.add("Home")
        listOfTitles.add("Profile")
        listOfTitles.add("Notification")
        listOfTitles.add("Activity")
        listOfTitles.add("TimeLine")
    }


    private fun setUpViewPagerWithTabLayout() {
        val pagerAdapter = ViewPagerAdapter(this , listOfTitles)
        viewPager.adapter = pagerAdapter
        addTabLayoutMediator()
    }


    private fun setUpPagerTabLayout() {
        val viewPagerSingleAdapter = PagerAdapter(this,listOfTitles)
        viewPager.adapter = viewPagerSingleAdapter
        addTabLayoutMediator()

    }





    private fun addTabLayoutMediator() {

        TabLayoutMediator(
            tabLayout, viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = listOfTitles[position]
        }.attach()
    }


    private fun setUpBadgeForTabLayout() {
        //set the badge
        val badgeDrawable = badgeTabLayout.getTabAt(0)!!.orCreateBadge
        badgeDrawable.isVisible = true
        badgeDrawable.number = 5
    }

    private fun setUpIconWithBadgeForTabLayout() {
        //set the badge
        val badgeDrawable = iconBadgeTabLayout.getTabAt(0)!!.orCreateBadge
        badgeDrawable.isVisible = true
        badgeDrawable.number = 8
    }

}