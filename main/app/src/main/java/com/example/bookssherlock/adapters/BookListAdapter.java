package com.example.bookssherlock.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookssherlock.R;
import com.example.bookssherlock.models.AvailableBooks;

import java.util.List;

public class BookListAdapter extends ArrayAdapter<AvailableBooks> {

    private final List<AvailableBooks> books;

    public BookListAdapter(@NonNull Context context, int resource, @NonNull List<AvailableBooks> objects) {
        super(context, resource, objects);
        this.books = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if (convertView == null)
            row = inflater.inflate(R.layout.list_book, null, true);
        final AvailableBooks book = this.books.get(position);
        int drawable = getContext().getResources().getIdentifier(book.getImage(), "drawable", getContext().getPackageName());
        final ImageView icon = row.findViewById(R.id.bookIcon);
        icon.setImageResource(drawable);
        final TextView title = row.findViewById(R.id.bookTitle);
        title.setText(book.getTitle());

        return row;
    }
}
