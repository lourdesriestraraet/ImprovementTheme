package es.raet.lourdesriestra.improvementtheme.structure.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Task implements Serializable {

    private static final long serialVersionUID = 3944092425162281034L;
    @SerializedName("id")
    private int _id;
    @SerializedName("description")
    private String _description;
    @SerializedName("state")
    private String _state;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public String get_state() {
        return _state;
    }

    public void set_state(String _state) {
        this._state = _state;
    }

    @Override
    public String toString() {
        return "Task{" +
                " id=" + _id +
                ", description='" + _description + '\'' +
                ", state='" + _state + '\'' +
                '}';
    }
}
