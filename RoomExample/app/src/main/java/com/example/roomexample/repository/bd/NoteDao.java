package com.example.roomexample.repository.bd;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertNote(NoteEntity note);

    @Query("SELECT * FROM note_table")
    LiveData<List<NoteEntity>> getNotes();
}
