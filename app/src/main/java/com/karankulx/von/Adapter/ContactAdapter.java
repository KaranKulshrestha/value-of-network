package com.karankulx.von.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.karankulx.von.ChatActivity;
import com.karankulx.von.Models.Contact;
import com.karankulx.von.Models.Users;
import com.karankulx.von.R;
import com.karankulx.von.databinding.RowConversationBinding;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    private ArrayList<Users> contactDetails;
    private Context context;

    public ContactAdapter(ArrayList<Users> contactDetails, Context context) {
        this.contactDetails = contactDetails;
        this.context = context;
    }

    public void filterList(ArrayList<Users> filterlist) {
        contactDetails = filterlist;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_conversation, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Users modal = contactDetails.get(position);
        holder.binding.chaterName.setText(modal.getName());
        Glide.with(context).load(modal.getProfilePic()).placeholder(R.drawable.userprofile)
                        .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.binding.profileImage);
        holder.binding.mainBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("username", holder.binding.chaterName.getText().toString());
                intent.putExtra("profileUri", modal.getProfilePic());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return contactDetails.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        RowConversationBinding binding;

        public ContactViewHolder(View itemView) {
            super(itemView);
            binding = RowConversationBinding.bind(itemView);
        }

    }

}
