package com.example.shoping;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.icu.text.CaseMap.Title;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class cart extends AppCompatActivity {
    int[] IMAGES={
            R.drawable.img1,R.drawable.img5,R.drawable.img6,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12

    };


    boolean item=true;
    ArrayList<String>  al,productname1,Price1;
    ArrayList<Integer> img;
    String[] names={"Jumki 1", "Jumki 2", "Jumki 3","Hand Bag 1","Hand Bag 2", "Hand Bag 3","Lipstick 1","Lipstick 2","Lipstick 3","chappal 1","chappal 2","Chappal 3"};
    String[] price={"200","100","300","500","1200","1600","150","250","300","500","1000","2000"};
    ListView lv;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ll=findViewById(R.id.alert_Layout);
setTitle("Cart");


        al= new ArrayList<>();
        img= new ArrayList<>();
        productname1= new ArrayList<>();
        Price1= new ArrayList<>();
        Intent i = getIntent();
        al.clear();
        for(int j=0;j<12;j++)
            al.add(j,i.getStringExtra(String.valueOf(j)));

        for(int j=0;j<al.size();j++) {
            if (Integer.parseInt(al.get(j)) < 13) {
                {
                    item=false;
                    img.add(IMAGES[j]);
                    productname1.add(names[j]);
                    Price1.add(price[j]);

                }
            }
        }


        lv = findViewById(R.id.list_cart);
        CustomAdapter customAdapter = new CustomAdapter();
        if(!item) {
            ll.setVisibility(View.GONE);
            lv.setVisibility(View.VISIBLE);
            lv.setAdapter(customAdapter);
        }
        else
        {
            ll.setVisibility(View.VISIBLE);
            lv.setVisibility(View.GONE);

        }


    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return img.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView= getLayoutInflater().inflate(R.layout.custom_layout,null);
            ImageView imageView = convertView.findViewById(R.id.imageView3);
            TextView productName = convertView.findViewById(R.id.textView4);
            TextView productCost = convertView.findViewById(R.id.textView5);

            imageView.setImageResource(img.get(position));
            productName.setText("Product Name :"+productname1.get(position));
            productCost.setText("Price Rs:"+Price1.get(position)+"/-");

            return convertView;
        }
    }
}
