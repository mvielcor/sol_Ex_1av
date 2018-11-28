package pmdm.manel.sol_ex_1av;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements BotoneraFragment.ComunicadorAmbActivity{

    private BotoneraFragment fb;
    private EmailFragment fe;
    private FragmentManager fm;
    private final int ID_SUBACTIVITY=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm=getFragmentManager();
        fb=(BotoneraFragment) fm.findFragmentById(R.id.fragment2);
        fe=(EmailFragment) fm.findFragmentById(R.id.fragment);
        fb.setColorFons();

    }

    @Override
    public void confirmaDadesEmail() {
        String dest,missatge,assumpte;
        dest = fe.getTextDestinatari();
        missatge = fe.getTextMissatge();
        assumpte = fe.getTextAssumpte();
        //comprovaria que els camps no estan buits
        if(dest.isEmpty() || missatge.isEmpty() || assumpte.isEmpty()){
            //Mostrar missatge que falta algun camp per omplir
        }else{
            //Guardem les dades al Bundle
            Bundle dadesAPassarAlSubactivity = new Bundle();
            dadesAPassarAlSubactivity.putString("destinatari",dest);
            dadesAPassarAlSubactivity.putString("missatge",missatge);
            dadesAPassarAlSubactivity.putString("assumpte",assumpte);

            Intent i = new Intent(getApplicationContext(),Subactivity.class);
            i.putExtras(dadesAPassarAlSubactivity);
            startActivityForResult(i,ID_SUBACTIVITY);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        fb.setColorFons();
    }

    @Override
    public void mostraPreferencies() {
        Intent i = new Intent (getApplicationContext(),ActivityPreferencies.class);
        startActivity(i);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ID_SUBACTIVITY) {
            if (resultCode == RESULT_OK) {
                fe.buidarCamps();
            }

        }
    }
}
