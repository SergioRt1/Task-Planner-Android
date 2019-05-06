package com.sergiort.taskplanner.db.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


import java.util.Date;

@Entity(foreignKeys = {
        @ForeignKey(entity = User.class,
                parentColumns = "username",
                childColumns = "owner"),
        @ForeignKey(entity = User.class,
                parentColumns = "username",
                childColumns = "responsible")
})
public class Task {

    @PrimaryKey
    @NonNull
    private String id;

    private String owner;
    private Date dueDate;
    private String responsible;
    private String state;
    private String description;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
