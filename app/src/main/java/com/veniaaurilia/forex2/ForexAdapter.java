package com.veniaaurilia.forex2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.jar.JarException;

public class ForexAdapter extends RecyclerView.Adapter<ForexViewHolder> {

    private JSONObject _rates;
    private JSONArray _name;
     public ForexAdapter(JSONObject rates){
         this._rates = rates;
         _name = rates.names();
     }
    @NonNull
    @Override
    public ForexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_forex,parent,false);
        return new ForexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForexViewHolder holder, int position) {
        try {
            String kode = _name.get(position).toString();
            holder.kodeTextView.setText(kode);

            double kurs = _rates.getDouble(kode);
            DecimalFormat decimalFormat = new DecimalFormat("###,##0.##");
            String kurs_2 = decimalFormat.format(kurs);
            holder.kursTextView.setText(kurs_2);
        } catch (JSONException e) {
            Log.e("*tw*", e.getMessage());
            return;
        }
    }



    @Override
    public int getItemCount() {
        return _name.length();
    }
}
