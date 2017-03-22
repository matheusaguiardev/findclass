package unifor.com.br.findclass.views;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import unifor.com.br.findclass.adapter.PagerAdapter;

/**
 * Created by matheusaguiar on 22/03/17.
 */

public class GenericActivity extends AppCompatActivity {

    private PagerAdapter pagerAdapter;

    protected TabLayout configTablayout(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText("Perfil"));
        tabLayout.addTab(tabLayout.newTab().setText("Buscar"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        return tabLayout;
    }

    protected ViewPager configViewPager(TabLayout tabLayout, ViewPager viewPager) {
        this.pagerAdapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(this.pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return viewPager;
    }

}
