package com.example.android.common.basevpadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class BaseViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    var mFragmentList: MutableList<Fragment> = ArrayList<Fragment>()
    var mFragmentTitleList: MutableList<String> = ArrayList<String>()

    fun addFragment(fragment: Fragment, fragmentTitle: String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(fragmentTitle)
    }

    override fun getItemCount(): Int {
        return mFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragmentList.get(position)
    }

}