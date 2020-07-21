package com.example.roomexample.repository.bd;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;
import java.util.UUID;


@Entity(tableName = "note_table")
public class NoteEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "noteId")
    private String mId;

    @ColumnInfo(name = "title")
    private String mTitle;

    @Ignore
    public NoteEntity(String title) {
        mId = UUID.randomUUID().toString();
        mTitle = title;
    }

    public NoteEntity(@NonNull String id, String title) {
        this.mId = id;
        this.mTitle = title;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteEntity that = (NoteEntity) o;
        return mId.equals(that.mId) &&
                Objects.equals(mTitle, that.mTitle);
    }

    @SuppressLint("NewApi")
    @Override
    public int hashCode() {
        return Objects.hash(mId, mTitle);
    }
}
