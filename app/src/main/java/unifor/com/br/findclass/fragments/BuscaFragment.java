package unifor.com.br.findclass.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unifor.com.br.findclass.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscaFragment extends Fragment {


    public BuscaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_busca, container, false);
    }

}
