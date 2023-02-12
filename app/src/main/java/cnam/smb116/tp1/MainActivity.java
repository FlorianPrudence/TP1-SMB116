package cnam.smb116.tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tp1smb116.R;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    static int started;
    //int started;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //started = getIntent().getIntExtra("started", 0);
        textView = (TextView)findViewById(R.id.textView1);
        textView.append("\n onCreate " + started);
    }

    public void actionStart(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("onClickStart");
        alertDialog.setMessage("Démarrage d'une nouvelle activité, même code");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(MainActivity.this,MainActivity.class);  // création d'une autre activité avec le même code
                        //intent.putExtra("started", started + 1);
                        started++;
                        startActivity(intent);
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Annuler",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void actionFinish(View view) {
        started--;
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView.append("\n onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.append("\n onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        textView.append("\n onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        textView.append("\n onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        textView.append("\n onStop");
    }
}