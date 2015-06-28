package es.raet.lourdesriestra.improvementtheme.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import es.raet.lourdesriestra.improvementtheme.AppGeneral;
import es.raet.lourdesriestra.improvementtheme.R;
import es.raet.lourdesriestra.improvementtheme.customviews.CustomTV;
import es.raet.lourdesriestra.improvementtheme.structure.models.Board;
import es.raet.lourdesriestra.improvementtheme.view.fragment.adapter.ListTaskAdapter;

public class BoardFragment extends Fragment {

    public static final String ARG_BOARD_NAME = "board_id";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content, container, false);
        Board board = AppGeneral.getInfoImprovement().get_boardList().getBoardList().get(getArguments().getInt(ARG_BOARD_NAME));

        ((CustomTV) rootView.findViewById(R.id.board_title))
                .setText(board.get_name());
        if (board.get_time_weeks() != -1) {
            ((CustomTV) rootView.findViewById(R.id.board_weeks_from_now))
                    .setText(board.get_time_weeks() + " " + AppGeneral.getContextApp().getString(R.string.fragments_weeks_from));
        } else {
            ((CustomTV) rootView.findViewById(R.id.board_weeks_from_now))
                    .setText("");
        }

        ListTaskAdapter adaptador =
                new ListTaskAdapter(board.get_taskList());

        ListView lstOpciones = (ListView) rootView.findViewById(R.id.list_task);

        lstOpciones.setAdapter(adaptador);
        return rootView;
    }
}