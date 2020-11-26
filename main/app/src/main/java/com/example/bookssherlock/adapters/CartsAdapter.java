package com.example.bookssherlock.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookssherlock.R;
import com.example.bookssherlock.models.Carts;
import com.example.bookssherlock.sqlite.DbHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CartsAdapter extends ArrayAdapter<Carts> {

    private final List<Carts> carts;

    private final DbHelper dbHelper;

    private final String email;

    public CartsAdapter(@NonNull Context context, int resource, @NonNull List<Carts> objects, DbHelper dbHelper, String email) {
        super(context, resource, objects);
        this.carts = objects;
        this.dbHelper = dbHelper;
        this.email = email;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if (convertView == null)
            row = inflater.inflate(R.layout.carts_list, null, true);
        final Carts cart = this.carts.get(position);
        int drawable = getContext().getResources().getIdentifier(cart.getImage(), "drawable", getContext().getPackageName());
        final ImageView icon = row.findViewById(R.id.bookIcon);
        icon.setImageResource(drawable);
        final TextView title = row.findViewById(R.id.bookTitle);
        title.setText("Price: " + cart.getPrice());
        final Button button = row.findViewById(R.id.buyBtn);
        button.setOnClickListener(v -> {
            this.createOrder(position);
            this.carts.remove(position);
            this.notifyDataSetChanged();

            AlertDialog alert = new AlertDialog.Builder(getContext()).create();
            alert.setTitle("The order has processed. The total cost of the books is " + cart.getPrice());
            //alert to display that order has been processed
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", (dialog, which) -> {});
            alert.show();
        });
        return row;
    }

    private void createOrder(final int position) {
        final Carts cart = this.carts.get(position);
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        writableDatabase.execSQL(
                "INSERT into orders(buy_id,seller_b_id,price,date,status) " +
                        "values " +
                        "((select id from users where email=?),?,?,?,'SOLD');",
                new Object[]{this.email, cart.getSellerBookId(), cart.getPrice(), format.format(new Date())}
        );
        writableDatabase.execSQL("DELETE from carts where id = ?", new Object[]{cart.getCartId()});
    }
}
