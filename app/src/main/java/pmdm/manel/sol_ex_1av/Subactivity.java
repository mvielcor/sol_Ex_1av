package pmdm.manel.sol_ex_1av;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Subactivity extends Activity implements View.OnClickListener{

    TextView tv;
    Button b_si,b_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);
        tv = (TextView) findViewById(R.id.tv_contingut_email);
        b_si = (Button)  findViewById( R.id.btn_si);
        b_no = (Button)  findViewById( R.id.btn_no);

        b_si.setOnClickListener(this);
        b_no.setOnClickListener(this);

        //REcollim els parametres que ens envia el MainActivity
        Bundle b= getIntent().getExtras();

        StringBuilder sb = new StringBuilder();
        sb.append(b.get("destinatari"));
        sb.append(b.get("assumpte"));
        sb.append(b.get("missatge"));

        tv.setText(sb.toString());


    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent();

        if(view.getId()==R.id.btn_si){
           setResult(RESULT_OK);
        }else{
            setResult(RESULT_CANCELED);
        }
        finish();
    }
}
