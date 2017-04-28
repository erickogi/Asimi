package com.erickogi14gmail.asimi.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erickogi14gmail.asimi.Data.DBPojo;
import com.erickogi14gmail.asimi.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kimani kogi on 4/21/2017.
 */

public class Remainders_Model_Adapter extends RecyclerView.Adapter<Remainders_Model_Adapter.MyViewHolder> {
    Context context;
    private ArrayList<DBPojo> modelList;

    public Remainders_Model_Adapter(Context context) {
        this.context = context;
        // this.listData = listData;
    }

    public Remainders_Model_Adapter(ArrayList<DBPojo> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DBPojo model = modelList.get(position);
        holder.textView_remainder_name.setText(model.getREMAINDER_NAME());
        holder.textView_remainder_description.setText(model.getREMAINDER_DESCRIPTION());
        holder.textView_remainder_place.setText(model.getREMAINDER_PLACE_NAME());

        long j = (model.getREMAINDER_TIME());
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd,yyyy HH:mm");
        Date rs = new Date(j);


        holder.textView_remainder_time.setText(String.valueOf(rs));
        holder.txtId.setText(String.valueOf(model.getID()));

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public interface OnItemClickListener {

        void onItemClick(DBPojo item);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_remainder_name,
                textView_remainder_description,
                textView_remainder_place, textView_remainder_time, txtId;


        public MyViewHolder(View view) {
            super(view);
            textView_remainder_name = (TextView) view.findViewById(R.id.txt_remainder_list_title);
            textView_remainder_description = (TextView) view.findViewById(R.id.txt_remainder_list_description);
            textView_remainder_place = (TextView) view.findViewById(R.id.txt_remainder_place);
            textView_remainder_time = (TextView) view.findViewById(R.id.txt_remainder_time);
            txtId = (TextView) view.findViewById(R.id.txt_remainder_id);


        }
    }

}

