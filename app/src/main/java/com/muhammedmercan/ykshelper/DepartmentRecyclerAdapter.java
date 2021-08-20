package com.muhammedmercan.ykshelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DepartmentRecyclerAdapter extends RecyclerView.Adapter<DepartmentRecyclerAdapter.MyViewHolder> {

    private ArrayList<Department> departments;
    private Context context;


    public DepartmentRecyclerAdapter(ArrayList<Department> departments, Context context) {
        this.departments = departments;
        this.context = context;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtPoint, txtPlacementRanking, txtDepartment, txtAdditionalInfo, txtCity, txtTypeOfDepartment;
        CardView parent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPoint = itemView.findViewById(R.id.txtPoint);
            txtPlacementRanking = itemView.findViewById(R.id.txtPlacementRanking);
            txtDepartment = itemView.findViewById(R.id.txtDepartment);
            txtAdditionalInfo = itemView.findViewById(R.id.txtAdditionalInfo);
            txtCity = itemView.findViewById(R.id.txtCity);
            txtTypeOfDepartment = itemView.findViewById(R.id.txtTypeOfDepartment);
            parent = itemView.findViewById(R.id.parent);
        }
    }


    @NonNull
    @Override
    public DepartmentRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.department_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  DepartmentRecyclerAdapter.MyViewHolder holder, int position) {
        //System.out.println(departments);
        holder.txtName.setText(departments.get(position).getUniversity());
        holder.txtPoint.setText(departments.get(position).getPlacementPoint2020());
        holder.txtPlacementRanking.setText(Integer.toString(departments.get(position).getPlacementRanking2020()));
        holder.txtDepartment.setText(departments.get(position).getDepartment());
        holder.txtAdditionalInfo.setText("(" + departments.get(position).getAdditionalInfo() + ")");
        holder.txtCity.setText(departments.get(position).getCity());
        holder.txtTypeOfDepartment.setText(departments.get(position).getTypeOfDepartment());

    }

    @Override
    public int getItemCount() {
        return departments.size();
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
        notifyDataSetChanged();
    }
}
