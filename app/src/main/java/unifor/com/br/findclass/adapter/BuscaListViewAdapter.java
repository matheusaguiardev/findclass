package unifor.com.br.findclass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import unifor.com.br.findclass.R;
import unifor.com.br.findclass.model.Reserva;
import unifor.com.br.findclass.model.Sala;

/**
 * Created by matheusaguiar on 24/03/17.
 */

public class BuscaListViewAdapter extends BaseAdapter {

    private ArrayList<Sala> salaArrayList = new ArrayList<>();

    private Context context;

    @Override
    public int getCount() {
        return salaArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return salaArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.sala_item_view, parent, false);
        TextView labelTextView = (TextView) rowView.findViewById(R.id.label_text_view);
        ImageButton buttonCancel = (ImageButton) rowView.findViewById(R.id.cancel_button);

        if (!salaArrayList.get(position).getLaboratorio()) {
            labelTextView.setText(salaArrayList.get(position).getNome()
                    + " - Sala" + salaArrayList.get(position).getNumero()
            );
        } else {
            labelTextView.setText(salaArrayList.get(position).getNome()
                    + " - Sala " + salaArrayList.get(position).getNumero()
                    + " - Lab");
        }


        if (salaArrayList.get(position).getOculpada()) {
            buttonCancel.setVisibility(View.VISIBLE);
        } else {
            buttonCancel.setVisibility(View.INVISIBLE);
        }

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Cancelar pedido da sala", Toast.LENGTH_SHORT).show();
            }
        });


        return rowView;
    }


    public ArrayList<Sala> getSalaArrayList() {
        return salaArrayList;
    }

    public void setSalaArrayList(ArrayList<Sala> salaArrayList) {
        this.salaArrayList = salaArrayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
