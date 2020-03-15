package top.horsttop.appcore.ui.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter


class TabViewPagerAdapter : FragmentStatePagerAdapter {
    private var mFragments: List<Fragment>? = null
    private var mTitles: List<String>? = null

    constructor(fm: FragmentManager, fragments: List<Fragment>, titles: List<String>) : super(fm) {
        for (i in fragments.indices) {
            fm.beginTransaction().add(fragments[i], i.toString() + "")
        }
        mFragments = fragments
        mTitles = titles
    }

    constructor(fm: FragmentManager, mFragments: List<Fragment>) : super(fm) {
        this.mFragments = mFragments
    }

    override fun getItem(position: Int): Fragment {
        return mFragments!![position]
    }

    override fun getCount(): Int {
        return mFragments!!.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitles?.get(position)
    }

    //viewpager 内容动态变更关键方法
    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }
}