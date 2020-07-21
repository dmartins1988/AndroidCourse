package com.example.roomexample.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomexample.R;
import com.example.roomexample.repository.bd.NoteEntity;

import java.util.List;


public class NotesAdapter
        extends ListAdapter<NoteEntity, NotesAdapter.NotesViewHolder> {


    public NotesAdapter() {
        super(new NoteEntityDC());
    }


    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public static class NotesViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        NotesViewHolder(View inflate) {
            super(inflate);
            title = itemView.findViewById(R.id.note_title_textView);
        }


        public void bind(NoteEntity item) {
            title.setText(item.getTitle());
        }
    }


    private static class NoteEntityDC extends DiffUtil.ItemCallback<NoteEntity> {
        @Override
        public boolean areItemsTheSame(@NonNull NoteEntity oldItem,
                                       @NonNull NoteEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull NoteEntity oldItem,
                                          @NonNull NoteEntity newItem) {
            return oldItem.getId().equals(newItem.getId());
        }
    }
}