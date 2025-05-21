package com.example.notes_mad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private final Context context;
    private final ArrayList<String> notes;

    public NoteAdapter(Context context, ArrayList<String> notes) {
        this.context = context;
        this.notes = notes;
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView noteText;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteText = itemView.findViewById(R.id.notePreview);
        }
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        String note = notes.get(position);
        holder.noteText.setText(note);

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context, "Clicked Note:\n" + note, Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
