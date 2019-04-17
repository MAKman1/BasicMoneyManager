package com.basit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DebtsAdapter extends RecyclerView.Adapter<DebtsAdapter.MyViewHolder> {

    private ArrayList<Debt> debtList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date, month, title, description, amount;

        public MyViewHolder(View view) {
            super(view);
            date = (TextView) view.findViewById(R.id.date);
            month = (TextView) view.findViewById(R.id.month);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
            amount = (TextView) view.findViewById(R.id.amount);
        }
    }


    public DebtsAdapter(ArrayList<Debt> debtList) {
        this.debtList = debtList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_expense, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Debt debt = debtList.get(position);
        holder.date.setText("" + debt.date);
        holder.month.setText( "" + MainActivity.months[ debt.month]);
        holder.title.setText( "" + debt.to);
        holder.description.setText( "" + debt.description);
        holder.amount.setText( "" + debt.amount);
    }

    @Override
    public int getItemCount() {
        return debtList.size();
    }
}