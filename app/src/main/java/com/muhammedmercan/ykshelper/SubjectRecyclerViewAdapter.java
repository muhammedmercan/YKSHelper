package com.muhammedmercan.ykshelper;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubjectRecyclerViewAdapter extends RecyclerView.Adapter<SubjectRecyclerViewAdapter.MyViewHolder> {

    ArrayList<Subject> subjects;
    Context context;
    SharedPreferences preferences;


    public SubjectRecyclerViewAdapter(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  SubjectRecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.checkBox.setText(subjects.get(position).getCheckBoxSubject());
        context = holder.checkBox.getContext();

        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Boolean checkSituation = preferences.getBoolean(subjects.get(position).getCheckBoxSubject(), false);
        System.out.println(subjects.get(position).getCheckBoxSubject() + " " + checkSituation);

        holder.checkBox.setOnCheckedChangeListener(null);

        holder.checkBox.setChecked(checkSituation);



        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                 if (holder.checkBox.isChecked())  {
                     setSharedPreferences(subjects.get(position).getCheckBoxSubject(),true);
                 }
                 else {
                     setSharedPreferences(subjects.get(position).getCheckBoxSubject(),false);
                 }
            }
        });
    }

    private void setSharedPreferences(String name, boolean check) {

        preferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(name,check);
        editor.apply();
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        CheckBox checkBox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.subjectCheckBox);
            cardView = itemView.findViewById(R.id.parent);
        }
    }
}
