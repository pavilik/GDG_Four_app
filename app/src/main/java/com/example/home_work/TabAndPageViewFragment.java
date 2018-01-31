package com.example.home_work;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabAndPageViewFragment extends Fragment  {
    List<Fragment> tabs = new ArrayList<>();


    public TabAndPageViewFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    tabs.add(new RedFragment());
    tabs.add(new BlankFragment());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View v = inflater.inflate(R.layout.fragment_tab_and_page_view, container, false);

        TabPagerAdapter TabSectionsPagerAdapter = new TabPagerAdapter(getChildFragmentManager());
ViewPager viewPager = v.findViewById(R.id.tabViewPager);
viewPager.setAdapter(TabSectionsPagerAdapter);


        TabLayout tabLayout =v.findViewById(R.id.tabLayout);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));


        // Inflate the layout for this fragment
        return v;
    }



    public class TabPagerAdapter extends FragmentPagerAdapter  {



        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return tabs.get(position);
        }

        @Override
        public int getCount() {
            return tabs.size();
        }


    }


}
