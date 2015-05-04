package com.empire.kinonewapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.empire.kinonewapplication.ArchiveTab;
import com.empire.kinonewapplication.RepertoireTab;
import com.empire.kinonewapplication.SoonTab;

/**
 * Created by Ivanco on 04.05.2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created

    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[],int mNumbofTabs) {
        super(fm);
        this.NumbOfTabs = mNumbofTabs;
        this.Titles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        {
            RepertoireTab repertoireTab = new RepertoireTab();
            return repertoireTab;
        }
        if (position == 1) {

            SoonTab naskoroTab = new SoonTab();
            return naskoroTab;
        }

        else {
            ArchiveTab arhivaTab = new ArchiveTab();
            return arhivaTab;
        }
    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
