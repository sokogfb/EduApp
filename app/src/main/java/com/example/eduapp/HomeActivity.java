package com.example.eduapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.eduapp.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Articles");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_ham);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.nav_post:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_material:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        //TODO intent here
                        break;
                    case R.id.nav_tasks:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        //TODO intent here
                        break;
                    case R.id.nav_quiz:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        //TODO intent here
                        break;
                    default:
                        drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if(R.id.log_out == item_id){
            FirebaseAuth.getInstance().signOut();
            finish();
        }else{
            if(android.R.id.home == item_id){
                drawerLayout.openDrawer(GravityCompat.START);
            }
        }
        return true;
    }
}