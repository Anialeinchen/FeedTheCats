package com.annamorgiel.feedthecats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anna Morgiel on 01.07.2017.
 */

public class Configurations extends AppCompatActivity {
    Cat[] ourCats;
    @BindView(R.id.conf_lv)
    ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configurations);
        ButterKnife.bind(this);

        String[] values = new String[]{"Blaubi", "Bailey", "Karo"
        };

        ourCats = new Cat[2];
        ourCats[0] = new Cat(values[0]);
        ourCats[1] = new Cat(values[1]);
        ourCats[2] = new Cat(values[2]);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.configuration_cat_details, R.id.tv_conf_cat_name, values);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;
                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

