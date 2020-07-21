package com.example.roomexample.ui.main;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.roomexample.R;
import com.example.roomexample.repository.bd.NoteEntity;
import com.example.roomexample.ui.adapter.NotesAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.roomexample.ui.utils.KeyboardUtils.hideKeyboard;

public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();

    private AppCompatEditText insertEditText;
    private Button insertButton;
    private RecyclerView recyclerView;

    private MainViewModel mViewModel;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NotesAdapter notesAdapter = new NotesAdapter();

        ViewModelFactory mViewModelFactory = Injection.provideViewModelFactory(getContext());
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(MainViewModel.class);

        recyclerView = view.findViewById(R.id.recyclerView);
        insertEditText = view.findViewById(R.id.note_editText);
        insertButton = view.findViewById(R.id.insert_button);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(notesAdapter);

        insertButton.setOnClickListener(v -> {
            if (insertEditText.getText() != null && !insertEditText.getText().toString().isEmpty()) {
                compositeDisposable.add(
                        mViewModel.addNote(new NoteEntity(insertEditText.getText().toString()))
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(() -> {
                                            insertEditText.setText("");
                                            hideKeyboard(requireActivity());
                                            Log.d(TAG, "Success");
                                        },
                                        throwable -> Log.e(TAG, "Error", throwable)));

            }
        });

        mViewModel.getNotes().observe(getViewLifecycleOwner(), notesAdapter::submitList);

    }



}