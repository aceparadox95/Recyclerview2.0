package com.mellon.recyclerview20;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapterCall extends RecyclerView.Adapter<RecyclerViewAdapterCall.ViewHolder> {

    private ArrayList<String> mImageNames;
    private ArrayList<String> mContact;
    private ArrayList<String> mImages;
    private Context mContext;


    public RecyclerViewAdapterCall(ArrayList<String> mImageNames, ArrayList<String> mContact, ArrayList<String> mImages, Context mContext) {
        this.mImageNames = mImageNames;
        this.mContact = mContact;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_call, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.img);

        holder.phone_name.setText(mImageNames.get(position));
        holder.phone_contact.setText((mContact.get(position)));

        holder.callLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(mContext, PhotoActivity.class);
//                intent.putExtra("image_url", mImages.get(position));
//                intent.putExtra("image_name", mImageNames.get(position));
//                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView phone_name;
        private TextView phone_contact;
        private ImageView img;
        LinearLayout callLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            phone_name = itemView.findViewById(R.id.name_contact);
            phone_contact = itemView.findViewById(R.id.phone_contact);
            img = itemView.findViewById(R.id.img_contact);
            callLayout = itemView.findViewById(R.id.call_layout);
        }
    }
}
