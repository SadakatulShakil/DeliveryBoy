package com.example.c2ldeliveryboy.View.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.c2ldeliveryboy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuContainerFragment extends Fragment {

    private BottomNavigationView bottomNavView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    private Context context;
    public MenuContainerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_container, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);

        if (getActivity() != null){
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_closed);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        initBottomNavigation();
        initNavigationViewDrawer();


        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new HomePageFragment())
                .commit();

    }

    private void initNavigationViewDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch ((item.getItemId())){

                    case R.id.settings:
                        Toast.makeText(context,"Settings Under Construction be Happy!", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.terms:
                        Toast.makeText(context,"Terms Under Construction be Happy!", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.licenses:
                        Toast.makeText(context,"Licenses Under Construction be Happy!", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.about:
                        Toast.makeText(context,"About Under Construction be Happy!", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

    }
    private void initBottomNavigation() {

        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;
                switch(item.getItemId()){
                    case R.id.home:
                        selectedFragment =new HomePageFragment();
                        break;
                    case R.id.history:
                        selectedFragment =new OrderHistoryFragment();
                        break;
                    case R.id.account:
                        selectedFragment =new AccountFragment();
                        break;
                    default:
                        break;
                }
                if (selectedFragment != null) {
                    FragmentManager fm = getChildFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentContainer,selectedFragment)
                            .commit();
                }
                return true;
            }
        });
    }


    private void initView(View view) {

        frameLayout = view.findViewById(R.id.fragmentContainer);
        drawerLayout = view.findViewById(R.id.drawer);
        navigationView = view.findViewById(R.id.navigationDrawer);
        toolbar = view.findViewById(R.id.mainTB);
        bottomNavView = view.findViewById(R.id.bottomNavigationView);

    }
}
