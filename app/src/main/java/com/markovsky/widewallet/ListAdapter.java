package com.markovsky.widewallet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item, viewGroup);

        //Присвоение значения Item из БД
        //...
        //...

        ItemViewHolder viewHolder = new ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        //Изменение данных Item при прокрутке
        //...
        //...
    }

    @Override
    public int getItemCount() {
        // Возвращение размера БД
        //...
        //...
        return 0;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemPrice;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.tvItemName);
            itemPrice = itemView.findViewById(R.id.tvItemPrice);
        }
    }

}



