package pmdm.manel.sol_ex_1av;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class BotoneraFragment extends Fragment implements View.OnClickListener{

    private ComunicadorAmbActivity comunicador;
    private Button btn_enviar;
    private ImageButton btn_preferencies;
    private LinearLayout layout_coloreable;
    private SharedPreferences preferenciesDUsuari;
    public BotoneraFragment() {
        // Required empty public constructor
    }


    public static BotoneraFragment newInstance(String param1, String param2) {
        BotoneraFragment fragment = new BotoneraFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_botonera,container,false);
        btn_enviar = v.findViewById(R.id.btn_enviar);
        btn_preferencies = v.findViewById(R.id.btn_configuracio);
        layout_coloreable = v.findViewById(R.id.layout_fragment_botonera);
        //assignem un Listener a cada botó
        btn_preferencies.setOnClickListener(this);
        btn_enviar.setOnClickListener(this);


        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ComunicadorAmbActivity) {
            comunicador = (ComunicadorAmbActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " has d'implementar ComunicadorAmbActivity");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        comunicador = null;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_configuracio){
            comunicador.mostraPreferencies();
        }
        if(view.getId()==R.id.btn_enviar){
            comunicador.confirmaDadesEmail();
        }
    }

    protected void setColorFons() {

        //Llegim les preferencies
        preferenciesDUsuari  = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        //color de fons
        String color = preferenciesDUsuari.getString("color_fragment","");

        //Pintem el layout del fragment del color que indica les preferencies
        if (color.equals("Roig")) {
            layout_coloreable.setBackgroundColor(Color.RED);
        } else {
            if (color.equals("Verd")) {
                layout_coloreable.setBackgroundColor(Color.GREEN);
            } else {
                if (color.equals("Blau")) {
                    layout_coloreable.setBackgroundColor(Color.BLUE);
                } else {
                    if (color.equals("Blanc")) {
                        layout_coloreable.setBackgroundColor(Color.WHITE);
                    }
                }
            }

        }
    }

    public interface ComunicadorAmbActivity {
        //Mètodes que utilitza el fragment per a comunicar-se amb l'activity
        void confirmaDadesEmail();
        void mostraPreferencies();
    }
}
