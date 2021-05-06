package com.example.mycontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private List<Contact> mListContact;
    private LayoutInflater mInflater;
    private Context mContext;

    public ContactAdapter(Context context, List<Contact> listContact) {
        this.mListContact = listContact;
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mListContact.size();
    }

    @Override
    public Object getItem(int position) {
        return mListContact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_contact, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.ivAvatar = convertView.findViewById(R.id.);
            viewHolder.tvName = convertView.findViewById(R.id.);
            viewHolder.tvPhone = convertView.findViewById(R.id.);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Contact contact = mListContact.get(position);

        viewHolder.tvPhone.setText(contact.getPhoneNumber());
        viewHolder.tvName.setText(contact.getName());
        if (contact.getAvatar() != null) {
            viewHolder.ivAvatar.setImageBitmap(contact.getAvatar());
        } else {
            viewHolder.ivAvatar.setImageResource(R.drawable.user);
        }

        return convertView;
    }


    private class ViewHolder {
        ImageView ivAvatar;
        TextView tvName;
        TextView tvPhone;
    }
}
