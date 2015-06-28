package es.raet.lourdesriestra.improvementtheme.structure.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Board implements Serializable {
    private static final long serialVersionUID = -4485186037340590627L;
    @SerializedName("tasks")
    List<Task> _taskList;
    @SerializedName("name")
    private String _name;
    @SerializedName("time_weeks")
    private int _time_weeks;

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_time_weeks() {
        return _time_weeks;
    }

    public void set_time_weeks(int _time_weeks) {
        this._time_weeks = _time_weeks;
    }

    public List<Task> get_taskList() {
        return _taskList;
    }

    public void set_taskList(List<Task> _taskList) {
        this._taskList = _taskList;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\n + Board +");
        result.append("\n\tname='" + _name + '\'');
        result.append("\n\ttime_weeks=" + _time_weeks);
        for (Task task : _taskList) {
            result.append("\n\t\t" + task.toString());
        }
        return result.toString();
    }
}
