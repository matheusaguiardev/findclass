package unifor.com.br.findclass.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import unifor.com.br.findclass.fragments.BuscaFragment;
import unifor.com.br.findclass.fragments.CadastroFragment;
import unifor.com.br.findclass.fragments.PerfilFragment;

/**
 * Created by matheusaguiar on 22/03/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PerfilFragment perfilFragment = new PerfilFragment();
                return perfilFragment;
            case 1:
                BuscaFragment buscaFragment = new BuscaFragment();
                return buscaFragment;
            case 2:
                CadastroFragment cadastroFragment = new CadastroFragment();
                return cadastroFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.mNumOfTabs;
    }
}
