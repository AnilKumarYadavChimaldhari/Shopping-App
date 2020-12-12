package com.example.shoping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ProductsPage extends AppCompatActivity implements View.OnClickListener {
    ImageView[] img;
    ArrayList<String > al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_page);
        img = new ImageView[12];
        al=new ArrayList<>();
  setTitle("Products");
        img[0]=findViewById(R.id.jumki1);
        img[1]=findViewById(R.id.jumki2);
        img[2]=findViewById(R.id.jumki3);
        img[3]=findViewById(R.id.hand_bag1);
        img[4]=findViewById(R.id.hand_bag2);
        img[5]=findViewById(R.id.hand_bag3);
        img[6]=findViewById(R.id.Lipstick1);
        img[7]=findViewById(R.id.Lipstick2);
        img[8]=findViewById(R.id.Lipstick3);
        img[9]=findViewById(R.id.chappal1);
        img[10]=findViewById(R.id.chappal2);
        img[11]=findViewById(R.id.chappal3);
        //img[0]=findViewById(R.id.jumki1);
        for(int k=0 ;k<12;k++) {
            img[k].setOnClickListener(this);
            al.add("13");
        }
        Intent i = getIntent();
        al.clear();
        for(int j=0;j<12;j++)
            al.add(j,i.getStringExtra(String.valueOf(j)));
    }

    @Override
    public void onClick(View v) {





        switch (v.getId()){

            case R.id.jumki1:
            {

                Snackbar snackbar;
                if(al.get(0).equals("0"))
                {
                    snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(0);
                            al.add(0,"13");
                        }
                    });
                }
                else{
                    al.remove(0);
                    al.add(0,"0");

                    snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                }
                snackbar.setActionTextColor(getResources().getColor(R.color.white));
                snackbar.setTextColor(getResources().getColor(R.color.white));
                snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                snackbar.show();

                break;
            }
            case R.id.jumki2:
            {
                if(al.get(1).equals("1"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(1);
                            al.add(1,"13");
                        }
                    });
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                else{
                    al.remove(1);
                    al.add(1,"1");

                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                break;
            }
            case R.id.jumki3:
            {

                if(al.get(2).equals("2"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(2);
                            al.add(2,"13");
                        }
                    });
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.show();
                }
                else{
                    al.remove(2);
                    al.add(2,"2");
                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }



                break;
            }
            case R.id.hand_bag1:
            {
                if(al.get(3).equals("3"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(3);
                            al.add(3,"13");
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                else{
                    al.remove(3);
                    al.add(3,"3");
                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }


                break;
            }
            case R.id.hand_bag2:
            {
                if(al.get(4).equals("4"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(4);
                            al.add(4,"13");
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                else{
                    al.remove(4);
                    al.add(4,"4");
                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }


                break;
            }
            case R.id.hand_bag3:
            {
                if(al.get(5).equals("5"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(5);
                            al.add(5,"13");
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                else{
                    al.remove(5);
                    al.add(5,"5");
                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }


                break;
            }
            case R.id.Lipstick1:
            {
                if(al.get(6).equals("6"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(6);
                            al.add(6,"13");
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                else{
                    al.remove(6);
                    al.add(6,"6");
                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }


                break;
            }
            case R.id.Lipstick2:
            {
                if(al.get(7).equals("7"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(7);
                            al.add(7,"13");
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                else{
                    al.remove(7);
                    al.add(7,"7");
                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }


                break;
            }
            case R.id.Lipstick3:
            {
                if(al.get(8).equals("8"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(8);
                            al.add(8,"13");
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                else{
                    al.remove(8);
                    al.add(8,"8");
                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }


                break;
            }
            case R.id.chappal1:
            {
                if(al.get(9).equals("9"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(9);
                            al.add(9,"13");
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                else{
                    al.remove(9);
                    al.add(9,"9");
                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }


                break;
            }
            case R.id.chappal2:
            {
                if(al.get(10).equals("10"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(10);
                            al.add(10,"13");
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                else{
                    al.remove(10);
                    al.add(10,"10");
                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }


                break;
            }
            case R.id.chappal3:
            {
                if(al.get(11).equals("11"))
                {
                    Snackbar snackbar = Snackbar.make(v, "ITEM Already Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Remove", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            al.remove(11);
                            al.add(11,"13");
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }
                else{
                    al.remove(11);
                    al.add(11,"11");
                    Snackbar snackbar = Snackbar.make(v, "ITEM Added Successfully to cart", Snackbar.LENGTH_LONG);
                    snackbar.setAction("BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent();
                            i.putExtra("count",String.valueOf(al.size()));
                            for(int j=0;j<al.size();j++)
                                i.putExtra(String.valueOf(j+20),al.get(j));
                            setResult(Activity.RESULT_OK,i);
                            finish();
                        }
                    });
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.setActionTextColor(getResources().getColor(R.color.pink));
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.show();
                }


                break;
            }

        }


    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra("count",String.valueOf(al.size()));
        for(int j=0;j<al.size();j++)
            i.putExtra(String.valueOf(j+20),al.get(j));
        setResult(Activity.RESULT_OK,i);
        finish();
    }
}
