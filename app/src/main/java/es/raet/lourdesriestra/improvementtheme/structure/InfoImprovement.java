package es.raet.lourdesriestra.improvementtheme.structure;

import com.google.gson.Gson;

import es.raet.lourdesriestra.improvementtheme.BuildConfig;
import es.raet.lourdesriestra.improvementtheme.structure.models.MainBoard;
import es.raet.lourdesriestra.improvementtheme.utils.LogC;

public class InfoImprovement {
    private MainBoard _boardList;

    public void getServerData() {
        _boardList = new MainBoard();
        String result = CollectDataServer.start(BuildConfig.JSON_URL);

        if (result != null) {
            LogC.d("Get the JSON (info): " + result);
            final Gson gson = new Gson();
            _boardList = gson.fromJson(result, MainBoard.class);
        } else {
            LogC.e("Error: Connect to server");
            _boardList = null;
        }
    }

    public MainBoard get_boardList() {
        return _boardList;
    }
}
