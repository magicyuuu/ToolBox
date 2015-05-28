package com.magicyu.toolbox.layout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import com.lidroid.xutils.view.annotation.ContentView;
import com.magicyu.toolbox.R;
import com.magicyu.toolbox.fragment.HugeButtonFragment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Main extends FragmentActivity {

    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @InjectView(R.id.mainMenu)
    ListView mainMenu;

    @InjectView(R.id.mainContent)
    FrameLayout mainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mainMenu.setAdapter(new ArrayAdapter<String>(
                        getBaseContext(),
                        R.layout.list_child,
                        R.id.menuItemText,
                        new String[]{"A", "B", "C", "D"}
                )
        );
    }

    @OnItemClick(R.id.mainMenu)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        logger.info(position + "");
        drawerLayout.closeDrawer(Gravity.LEFT);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.mainContent, new HugeButtonFragment());
        ft.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }
}
