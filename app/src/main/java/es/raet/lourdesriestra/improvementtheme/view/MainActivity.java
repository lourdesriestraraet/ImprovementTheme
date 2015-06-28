package es.raet.lourdesriestra.improvementtheme.view;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import es.raet.lourdesriestra.improvementtheme.R;
import es.raet.lourdesriestra.improvementtheme.view.fragment.adapter.BoardPagerAdapter;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    BoardPagerAdapter adapter;

    ViewPager viewpager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.setHomeButtonEnabled(false);

        adapter = new BoardPagerAdapter(getSupportFragmentManager());

        viewpager = (ViewPager) findViewById(R.id.main_board);
        viewpager.setAdapter(adapter);
        viewpager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        int idIcons[] = {
                R.drawable.ic_bug_report_white_48dp,
                R.drawable.ic_flight_takeoff_white_48dp,
                R.drawable.ic_grade_white_48dp,
                R.drawable.ic_supervisor_account_white_48dp};

        for (int i = 0; i < adapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setIcon(idIcons[i])
                            .setTabListener(this));
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

}

