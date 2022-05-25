package com.karankulx.von.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.karankulx.von.Models.Contact;
import com.karankulx.von.R;
import com.karankulx.von.databinding.RowConversationBinding;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    private ArrayList<Contact> contactDetails;
    private Context context;

    public ContactAdapter(ArrayList<Contact> contactDetails, Context context) {
        this.contactDetails = contactDetails;
        this.context = context;
    }

    public void filterList(ArrayList<Contact> filterlist) {
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
        Contact modal = contactDetails.get(position);
        holder.binding.chaterName.setText(modal.getName());
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
