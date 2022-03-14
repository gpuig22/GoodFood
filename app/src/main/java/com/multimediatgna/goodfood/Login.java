package com.multimediatgna.goodfood;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.multimediatgna.goodfood.ui.main.LoginFragment;
import com.multimediatgna.goodfood.ui.main.MainViewModel;

public class Login extends AppCompatActivity {

    private MainViewModel mViewModel;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater myinflater = getMenuInflater();
        myinflater.inflate(R.menu.main_fragment_menu, menu);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Bundle b = getIntent().getExtras();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if(b != null)
            mViewModel.setMycurrentuser(b.getString("username"));
            mViewModel.setMycurrentpassword(b.getString("password"));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case  R.id.item1:

                Fragment mFragment = null;
                mFragment = new DatabaseReadFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.myframelayout, mFragment).addToBackStack(null).commit();
                // Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                onBackPressed();
                return true;
             case  R.id.item2:
                //Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.item1subitem1:
                Toast.makeText(this, "SubItem 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.item1subitem2:
                Toast.makeText(this, "SubItem 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.myframelayout, LoginFragment.newInstance())
                    .commitNow();
        }



    }
}