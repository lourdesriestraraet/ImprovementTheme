package es.raet.lourdesriestra.improvementtheme.view.fragment.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import es.raet.lourdesriestra.improvementtheme.AppGeneral;
import es.raet.lourdesriestra.improvementtheme.view.fragment.BoardFragment;

public class BoardPagerAdapter extends FragmentPagerAdapter {

    public BoardPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return AppGeneral.getInfoImprovement().get_boardList().getBoardList().size();
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new BoardFragment();
        Bundle args = new Bundle();
        args.putInt(BoardFragment.ARG_BOARD_NAME, i);
        fragment.setArguments(args);
        return fragment;

    }
}