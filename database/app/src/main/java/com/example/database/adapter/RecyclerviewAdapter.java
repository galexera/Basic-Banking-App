package com.example.database.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.database.R;
import com.example.database.displayContact;
import com.example.database.model.Contact;
import java.util.List;

    public  class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>
    {

    private Context context;
    private List<Contact> contactList;

    public RecyclerviewAdapter(Context context, List<Contact> contactList) {
            this.context = context;
            this.contactList = contactList;
    }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Contact contact = contactList.get(position);
            holder.contactName.setText(contact.getName());
            holder.phoneNumber.setText(contact.getPhoneNumber());
        }

        @Override
        public int getItemCount() {
        return contactList.size();
        }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView contactName;
        public TextView phoneNumber;
        public ImageView iconButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            contactName = itemView.findViewById(R.id.nameid);
            phoneNumber = itemView.findViewById(R.id.numberid);
            iconButton = itemView.findViewById(R.id.icon);
            iconButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = this.getAdapterPosition();
            Contact contact = contactList.get(position);
            String name = contact.getName();
            String phone = contact.getPhoneNumber();
            String email = contact.getEmail();
            Integer balance = contact.getBalance();

            Intent intent = new Intent(context, displayContact.class);
            intent.putExtra("Rname", name);
            intent.putExtra("Rphone", phone);
            intent.putExtra("Remail", email);
            intent.putExtra("Rbalance",balance);
            context.startActivity(intent);
        }
    }
}
