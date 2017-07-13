package com.annamorgiel.feedthecats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.seekbar_tv)
    TextView seekbarTv;
    @BindView(R.id.seekbar)
    SeekBar seekbar;
    @BindView(R.id.bailey_cb)
    CheckBox addFoodBailey;
    @BindView(R.id.blaubi_cb)
    CheckBox addFoodBlaubi;
    @BindView(R.id.main_progress_bar_blaubi)
    ProgressBar blaubiTotalFoodAmount;
    @BindView(R.id.main_progress_bar_bailey)
    ProgressBar baileyTotalFoodAmount;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.confirm_cat_detials)
    Button addFood;
    private int currentFoodAmount;
    private int newFood;
    private int foodTotal;
    public static final int FOOD_TOTAL = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        initSeekBar();
        addFoodBailey.setChecked(true);
        addFoodBlaubi.setChecked(true);
        confirm();

    }

    private void confirm() {
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addFoodBailey.isChecked()) {
                    currentFoodAmount = baileyTotalFoodAmount.getProgress();
                    newFood = seekbar.getProgress();
                    foodTotal = currentFoodAmount + newFood;
                    if (foodTotal >= FOOD_TOTAL) {
                        Toast.makeText(MainActivity.this, "Das wäre " + (foodTotal - FOOD_TOTAL) + " Gramm zu viel!! \n höre sofort auf!",
                                Toast.LENGTH_LONG).show();
                    } else {
                        baileyTotalFoodAmount.setProgress(foodTotal);
                    }
                }
                if (addFoodBlaubi.isChecked()) {
                    currentFoodAmount = blaubiTotalFoodAmount.getProgress();
                    newFood = seekbar.getProgress();
                    blaubiTotalFoodAmount.setProgress(currentFoodAmount + newFood);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent_settings = new Intent(MainActivity.this, Configurations.class);
                startActivity(intent_settings);
                return true;
            case R.id.info:
                Intent intent_info = new Intent(MainActivity.this, Info.class);
                startActivity(intent_info);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initSeekBar() {
        seekbar.setMax(FOOD_TOTAL);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarTv.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
