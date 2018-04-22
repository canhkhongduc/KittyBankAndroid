package gamification.kitty.hackathon.kittybank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import gamification.kitty.hackathon.kittybank.entity.User;
import gamification.kitty.hackathon.kittybank.utils.Utils;

public class BankActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView tvUserFullname;
    private TextView tvAccountNumber;
    private LinearLayout llTransact;
    private LinearLayout llHistory;
    private LinearLayout llKitty;
    private TextView dlUserFullName;
    private TextView dlUserAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View parentView = navigationView.getHeaderView(0);
        dlUserFullName = parentView.findViewById(R.id.dlUserFullName);
        dlUserAccount = parentView.findViewById(R.id.dlUserAccount);
        tvAccountNumber = findViewById(R.id.tvUserCIF);
        tvUserFullname = findViewById(R.id.tvUsername);
        User user = Utils.getUserFromSharedPreference(this);
        dlUserFullName.setText(user.getFullName());
        dlUserAccount.setText(user.getAccountNumber());
        tvUserFullname.setText(user.getFullName());
        tvAccountNumber.setText("CIF: " + user.getAccountNumber());
        llTransact = findViewById(R.id.llTransact);
        llTransact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BankActivity.this, TransactActivity.class));
            }
        });
        llHistory = findViewById(R.id.llHistory);
        llHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BankActivity.this, HistoryActivity.class));
            }
        });
        llKitty = findViewById(R.id.llKitty);
        llKitty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BankActivity.this, HomeKittyActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bank, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_transact) {
            startActivity(new Intent(BankActivity.this, TransactActivity.class));
        } else if (id == R.id.nav_saving) {

        } else if (id == R.id.nav_history) {
            startActivity(new Intent(BankActivity.this, HistoryActivity.class));
        } else if (id == R.id.nav_pet) {
            startActivity(new Intent(BankActivity.this, HomeKittyActivity.class));
        } else if (id == R.id.nav_logout){
            Utils.destroySharedpreference(getApplicationContext());
            startActivity(new Intent(BankActivity.this, LoginActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
