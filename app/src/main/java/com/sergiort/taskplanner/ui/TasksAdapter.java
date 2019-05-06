package com.sergiort.taskplanner.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sergiort.taskplanner.R;
import com.sergiort.taskplanner.network.data.Task;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    private List<Task> taskList = null;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ) {
        return new ViewHolder( LayoutInflater.from( parent.getContext() ).inflate( R.layout.task_row, parent, false ) );
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position )
    {
        Task task = taskList.get( position );
//        holder.
        //TODO implement update view holder using the task values
    }

    @Override
    public int getItemCount() {
        return taskList != null ? taskList.size() : 0;
    }

    public void updateTasks(List<Task> tasks){
        this.taskList = tasks;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder( @NonNull View itemView ) {
            super( itemView );
        }
    }

}