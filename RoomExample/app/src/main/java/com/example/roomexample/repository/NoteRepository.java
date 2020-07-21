package com.example.roomexample.repository;

import androidx.lifecycle.LiveData;

import com.example.roomexample.repository.bd.NoteDao;
import com.example.roomexample.repository.bd.NoteEntity;

import java.util.List;

import io.reactivex.Completable;

public class NoteRepository {

    private final NoteDao noteDao;

    public NoteRepository(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public Completable insertNote(NoteEntity note) {
        return noteDao.insertNote(note);
    }

    public LiveData<List<NoteEntity>> getNotes() {
        return noteDao.getNotes();
    }
}
