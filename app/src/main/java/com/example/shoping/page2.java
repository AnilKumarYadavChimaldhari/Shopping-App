package com.example.shoping;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class page2 extends AppCompatActivity {
    Button count,shop,contact,back;
    TextView tv;
    String bill;
    private  int callPermission;

    ArrayList<String> al,produts,prod;
    String[] price={"200","100","300","500","1200","1600","150","250","300","500","1000","2000"};
    String[] names={"Jumki 1", "Jumki 2", "Jumki 3","Hand Bag 1","Hand Bag 2", "Hand Bag 3","Lipstick 1","Lipstick 2","Lipstick 3","chappal 1","chappal 2","Chappal 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        tv=findViewById(R.id.count_number1);
        String firstName=getIntent().getStringExtra("first");
        String lastName=getIntent().getStringExtra("last");
        setTitle(getString(R.string.Welcome)+" "+firstName+" "+lastName);
        count=findViewById(R.id.count);
        shop = findViewById(R.id.Shop);
        contact=findViewById(R.id.Contact);
        back=findViewById(R.id.Back);

        produts=new ArrayList<>();
        prod=new ArrayList<>();


        al=new ArrayList<>();

        for(int j=0;j<12;j++)
        {
            al.add(String.valueOf(13));
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this,ProductsPage.class);

                for(int j=0;j<al.size();j++)
                    i.putExtra(String.valueOf(j),al.get(j));

                startActivityForResult(i,1);
            }
        });

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cnt=0;
                for (int j=0;j<al.size();j++)
                {
                    if( Integer.parseInt(al.get(j))<12)
                        cnt++;

                }

                String alin="Anil \n kumar \n yadav";
                Toast.makeText(getApplicationContext(),alin,Toast.LENGTH_SHORT).show();
                // Toast.makeText(getApplicationContext(),""+al,Toast.LENGTH_SHORT).show();
                String text = getString(R.string.count_number)+String.valueOf(cnt);
                tv.setText(text);
            }
        });
    }

    public   void contact(View view) {

        make_Phone_call();

    }

    private void make_Phone_call() {

        if(ContextCompat.checkSelfPermission(page2.this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(page2.this,new String[] {Manifest.permission.CALL_PHONE},callPermission);
        }
        else
        {

            Intent i2= new Intent(Intent.ACTION_CALL);
            i2.setData(Uri.parse("tel:7036709734"));
            startActivity(i2);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == callPermission)
        {
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
                make_Phone_call();
            else{
                Intent i2= new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel:7036709734"));
                startActivity(i2);
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&& resultCode==RESULT_OK)
        {
            al.clear();
            Bundle b = data.getExtras();
            int count1=Integer.parseInt(b.getString("count"));
            for(int j=0;j<count1;j++)
                al.add(j,b.getString(String.valueOf(j+20)));

            // Toast.makeText(getApplicationContext(), "uyfuyfufy", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.cart)
        {
            Intent i = new Intent(page2.this,cart.class);

            for(int j=0;j<al.size();j++)
                i.putExtra(String.valueOf(j),al.get(j));

            startActivity(i);

        }
        else if(id==R.id.Shop1)
        {
            Intent i = new Intent(page2.this,ProductsPage.class);

            for(int j=0;j<al.size();j++)
                i.putExtra(String.valueOf(j),al.get(j));

            startActivityForResult(i,1);
        }
        else if(id==R.id.count1)
        {
            int cnt=0;
            for (int j=0;j<al.size();j++)
            {
                if( Integer.parseInt(al.get(j))<12)
                    cnt++;

            }
            // Toast.makeText(getApplicationContext(),""+al,Toast.LENGTH_SHORT).show();
            String text = getString(R.string.count_number)+String.valueOf(cnt);
            tv.setText(text);
        }
        else if( id == R.id.contact1)
            make_Phone_call();



        return super.onOptionsItemSelected(item);
    }
}
