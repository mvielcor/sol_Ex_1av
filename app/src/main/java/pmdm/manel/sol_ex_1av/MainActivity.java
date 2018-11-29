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
// Enllacem els objectes java (Fragments) amb els fragments que hem dissenyat a l'xml
        fm=getFragmentManager();
        fb=(BotoneraFragment) fm.findFragmentById(R.id.fragment2);
        fe=(EmailFragment) fm.findFragmentById(R.id.fragment);
        //Cridem al mètode que ens llegirà les preferencies i establirà el color del fragmentBotonera.
        fb.setColorFons();

    }

    @Override
    public void confirmaDadesEmail() {
        String dest,missatge,assumpte;
        dest = fe.getTextDestinatari();
        missatge = fe.getTextMissatge();
        assumpte = fe.getTextAssumpte();
        //comprovem que els camps no estiguen buits
        if(dest.isEmpty() || missatge.isEmpty() || assumpte.isEmpty()){
            //Mostrar missatge indicant que falta algun camp per omplir
        }else{
            //Guardem les dades al Bundle
            Bundle dadesAPassarAlSubactivity = new Bundle();
            dadesAPassarAlSubactivity.putString("destinatari",dest);
            dadesAPassarAlSubactivity.putString("missatge",missatge);
            dadesAPassarAlSubactivity.putString("assumpte",assumpte);
            //llancem el subactivity
            Intent i = new Intent(getApplicationContext(),Subactivity.class);
            i.putExtras(dadesAPassarAlSubactivity);
            startActivityForResult(i,ID_SUBACTIVITY);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Quan tornem a ficar este activity 'en execució' repintarem el fragment botonera al color que indiquen les preferencies
        fb.setColorFons();
    }

    @Override
    public void mostraPreferencies() {
        //LLancem l'activity que ens mostra les preferencies
        Intent i = new Intent (getApplicationContext(),ActivityPreferencies.class);
        startActivity(i);
    }


    @Override
    //Gestionem la informació que ens proporciona el subactivity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ID_SUBACTIVITY) {
            if (resultCode == RESULT_OK) {
                //Posem en blanc tots els camps de fragment Email
                fe.buidarCamps();
            }

        }
    }
}
