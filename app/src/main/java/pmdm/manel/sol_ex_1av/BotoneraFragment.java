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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BotoneraFragment.ComunicadorAmbActivity} interface
 * to handle interaction events.
 * Use the {@link BotoneraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BotoneraFragment extends Fragment implements View.OnClickListener{

    private ComunicadorAmbActivity comunicador;
    private Button btn_enviar;
    private ImageButton btn_preferencies;
    private LinearLayout layout_coloreable;
    private SharedPreferences preferenciesDUsuari;
    public BotoneraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BotoneraFragment.
     */
    // TODO: Rename and change types and number of parameters
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
                    + " must implement ComunicadorAmbActivity");
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
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface ComunicadorAmbActivity {
        // TODO: Update argument type and name
        void confirmaDadesEmail();
        void mostraPreferencies();
    }
}
