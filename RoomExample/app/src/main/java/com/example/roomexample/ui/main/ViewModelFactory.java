package com.example.roomexample.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.roomexample.repository.NoteRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final NoteRepository noteRepository;

    public ViewModelFactory(NoteRepository dataSource) {
        this.noteRepository = dataSource;
    }

    @Override
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(noteRepository);
        }
        //noinspection unchecked
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
