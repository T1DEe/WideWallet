package com.markovsky.widewallet;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class rvSpendsAdapter extends RecyclerView.Adapter<rvSpendsAdapter.SpendViewHolder> {

    private SQLiteDatabase database;

    public rvSpendsAdapter(SQLiteDatabase db)
    {
        database = db;
    }

    @NonNull
    @Override
    public SpendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.rv_list_item, viewGroup);

        //Присвоение значения Item из БД
        //...
        //...

        SpendViewHolder viewHolder = new SpendViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SpendViewHolder viewHolder, int i) {
        //Изменение данных Item при прокрутке
        //...
        //...
    }

    @Override
    public int getItemCount() {
        // Возвращение размера БД
        database.getPageSize();
        return 0;
    }

    class SpendViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemPrice;

        private SpendViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.tvItemName);
            itemPrice = itemView.findViewById(R.id.tvItemPrice);
        }
    }

}



