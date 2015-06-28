package es.raet.lourdesriestra.improvementtheme.structure.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MainBoard implements Serializable {

    private static final long serialVersionUID = 3082694354835040783L;
    @SerializedName("json_main_board")
    private List<Board> boardList;

    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Board board : boardList) {
            result.append(board.toString());
        }
        return result.toString();
    }
}
