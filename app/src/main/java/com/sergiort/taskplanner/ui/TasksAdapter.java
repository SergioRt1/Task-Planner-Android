package com.sergiort.taskplanner.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sergiort.taskplanner.R;
import com.sergiort.taskplanner.db.model.Task;

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

        holder.description.setText(task.getDescription());
        holder.state.setText(task.getState().toString());
        holder.dueDate.setText(task.getDueDate().toString());
        holder.responsibleName.setText(task.getResponsibleName());
        holder.responsibleEmail.setText(task.getResponsibleEmail());
    }

    @Override
    public int getItemCount() {
        return taskList != null ? taskList.size() : 0;
    }

    public void updateTasks(List<Task> tasks){
        this.taskList = tasks;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView description, state, dueDate, responsibleName, responsibleEmail;
        ViewHolder( @NonNull View itemView ) {
            super( itemView );
            description = itemView.findViewById(R.id.task_description);
            state = itemView.findViewById(R.id.task_state);
            dueDate = itemView.findViewById(R.id.task_due_date);
            responsibleName = itemView.findViewById(R.id.responsible_name);
            responsibleEmail = itemView.findViewById(R.id.responsible_email);
        }

    }

}