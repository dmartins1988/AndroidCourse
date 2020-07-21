package com.example.roomexample.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomexample.repository.NoteRepository;
import com.example.roomexample.repository.bd.NoteEntity;

import java.util.List;

import io.reactivex.Completable;

public class MainViewModel extends ViewModel {

    private final NoteRepository noteRepository;

    public MainViewModel(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Completable addNote(NoteEntity note) {
        return noteRepository.insertNote(note);
    }

    public LiveData<List<NoteEntity>> getNotes() {
        return noteRepository.getNotes();
    }
}