package pmdm.manel.sol_ex_1av;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link EmailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmailFragment extends Fragment {

    EditText et_destinatari, et_assumpte,et_missatge;

    public EmailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmailFragment newInstance(String param1, String param2) {
        EmailFragment fragment = new EmailFragment();
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
        View v =  inflater.inflate(R.layout.fragment_email,container,false);
        // Assignar objectes Java als elements de l'xml
        et_destinatari =(EditText) v.findViewById(R.id.tv_destinatari);
        et_assumpte = (EditText) v.findViewById(R.id.tv_assumpte);
        et_missatge = (EditText) v.findViewById(R.id.tv_missatge);
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    protected String getTextDestinatari() {
        return et_destinatari.getText().toString();
    }

    protected String getTextAssumpte() {
        return et_assumpte.getText().toString();
    }

    protected String getTextMissatge() {
        return et_missatge.getText().toString();
    }

    protected void buidarCamps(){
        et_missatge.setText("");
        et_assumpte.setText("");
        et_destinatari.setText("");
    }
}
