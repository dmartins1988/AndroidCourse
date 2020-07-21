package com.example.roomexample.ui.main;

import android.content.Context;

import com.example.roomexample.repository.NoteRepository;
import com.example.roomexample.repository.bd.NoteDatabase;

public class Injection {

    public static NoteRepository provideNoteRepository(Context context) {
        NoteDatabase database = NoteDatabase.getInstance(context);
        return new NoteRepository(database.noteDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        NoteRepository dataSource = provideNoteRepository(context);
        return new ViewModelFactory(dataSource);
    }
}
