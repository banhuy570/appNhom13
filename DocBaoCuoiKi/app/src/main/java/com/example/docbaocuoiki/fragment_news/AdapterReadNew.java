package com.example.docbaocuoiki.fragment_news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.docbaocuoiki.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterReadNew extends ArrayAdapter<ReadNew>{

        public AdapterReadNew(Context context, int resource, List<ReadNew> items) {
            super(context, resource, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                view =  inflater.inflate(R.layout.item_listview, null);
            }
            ReadNew p = getItem(position);
            if (p != null) {
                // Anh xa + Gan gia tri
                TextView textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
                textViewTitle.setText(p.title);

                ImageView imageViewImage = (ImageView) view.findViewById(R.id.imageViewImage);
                Picasso.with(getContext()).load(p.image).into(imageViewImage);


            }
            return view;
        }

    }

