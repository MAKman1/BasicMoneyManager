package com.basit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.MyViewHolder> {

    private ArrayList<Expense> expenseList;

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


    public ExpensesAdapter(ArrayList<Expense> moviesList) {
        this.expenseList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_expense, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        holder.date.setText("" + expense.date);
        holder.month.setText( "" + MainActivity.months[ expense.month]);
        holder.title.setText( "" + expense.title);
        holder.description.setText( "" + expense.description);
        holder.amount.setText( "" + expense.amount);
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }
}