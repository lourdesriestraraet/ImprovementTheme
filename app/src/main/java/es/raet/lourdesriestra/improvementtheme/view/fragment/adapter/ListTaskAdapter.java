package es.raet.lourdesriestra.improvementtheme.view.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import es.raet.lourdesriestra.improvementtheme.AppGeneral;
import es.raet.lourdesriestra.improvementtheme.R;
import es.raet.lourdesriestra.improvementtheme.customviews.CustomTV;
import es.raet.lourdesriestra.improvementtheme.structure.models.Task;
import es.raet.lourdesriestra.improvementtheme.utils.LogC;

public class ListTaskAdapter extends BaseAdapter {

    private List<Task> tasks;
    private LayoutInflater inflater = null;

    public ListTaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
        this.inflater = LayoutInflater.from(AppGeneral.getContextApp());
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        LogC.d("in getView for position " + position + ", convertView is "
                + ((convertView == null) ? "null" : "being recycled"));

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();

            holder.description_task = (CustomTV) convertView
                    .findViewById(R.id.info_task);
            holder.image_task = (ImageView) convertView
                    .findViewById(R.id.icon_task);

            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();

        holder.description_task.setText(tasks.get(position).get_description());
        if (tasks.get(position).get_state().equals("inprogress")) {
            holder.image_task.setImageResource(R.drawable.ic_play_circle_outline_black_48dp);
        } else if (tasks.get(position).get_state().equals("todo")) {
            holder.image_task.setImageResource(R.drawable.ic_label_outline_black_48dp);
        } else if (tasks.get(position).get_state().equals("done")) {
            holder.image_task.setImageResource(R.drawable.ic_done_all_black_48dp);
        } else if (tasks.get(position).get_state().equals("new")) {
            holder.image_task.setImageResource(R.drawable.ic_inbox_black_48dp);
        } else if (tasks.get(position).get_state().equals("awesome")) {
            holder.image_task.setImageResource(R.drawable.ic_favorite_border_black_48dp);
        } else {
            holder.image_task.setImageResource(R.drawable.ic_access_time_black_48dp);
        }

        return convertView;
    }

    static class ViewHolder {
        CustomTV description_task;
        ImageView image_task;
    }
}
