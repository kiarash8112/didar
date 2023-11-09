package com.kiarash8112gmail.didar;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by asus on 7/24/2017.
 */

public class RecyclinAdabter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


        public EditText faddress;
        public EditText fname;
        public EditText fphone;



        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
   public class freindViewHolder extends RecyclerView.ViewHolder {
       Button creat;
       EditText faddress;
       EditText fname;
       EditText fphone;
       public freindViewHolder(View itemView) {
           super(itemView);
           creat=(Button) itemView.findViewById(R.id.creat);
           fname=(EditText) itemView.findViewById(R.id.fname);
           fphone=(EditText)itemView.findViewById(R.id.fphone);
           faddress=(EditText)itemView.findViewById(R.id.faddress);

       }
   }


}