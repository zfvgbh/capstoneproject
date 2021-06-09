package com.`val`.cap0386

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class MainActivity : AppCompatActivity() {
    var fragments:ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(HomeFragment())
        fragments.add(ArticleFragment())
        fragments.add(AboutFragment())

        viewPager.adapter = Adapter(this,fragments)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> bottomNav.selectedItemId = R.id.itemHome
                    1 -> bottomNav.selectedItemId = R.id.itemArticle
                    2 -> bottomNav.selectedItemId = R.id.itemAbout
                }
            }
        })

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.itemHome -> viewPager.currentItem = 0
                R.id.itemArticle -> viewPager.currentItem = 1
                R.id.itemAbout -> viewPager.currentItem = 2
            }
            true
        }

    }
}