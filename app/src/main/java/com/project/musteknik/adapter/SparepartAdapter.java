package com.project.musteknik.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.musteknik.R;
import com.project.musteknik.RunnableValue;
import com.project.musteknik.model.ticket.DataItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SparepartAdapter extends RecyclerView.Adapter<SparepartAdapter.ViewHolder> {
    List<String> sparepart;
    Context context;
    private LayoutInflater mInflater;
    RunnableValue runnableValue;
    ArrayList<String> data;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    // data is passed into the constructor
    public SparepartAdapter(Context context, List<String> mList, RunnableValue runnableValue) {
        this.sparepart = mList;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.runnableValue = runnableValue;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_sparepart, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.sparepart.setText(sparepart.get(position).toString());
        runnableValue.run(holder.count.getText().toString());

        holder.count.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                runnableValue.run(position + "-" + charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return sparepart.size();
    }




    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView sparepart;
        EditText count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sparepart = itemView.findViewById(R.id.txt_sparepart);
            count = itemView.findViewById(R.id.count);

        }
    }

}
