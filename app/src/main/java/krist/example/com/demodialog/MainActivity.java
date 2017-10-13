package krist.example.com.demodialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener{


    @Override
    public void onClick(View view) {

        Button btnDlgSimple = (Button) findViewById(R.id.btnDlgSimple);

        if (btnDlgSimple == view){
        lst miListener = new lst();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Preparar dialogo
        builder.setMessage(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.txtBtnAceptar, miListener)
                .setNegativeButton(R.string.txtBtnCancelar,
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Presionaste el boton cancelar", Toast.LENGTH_SHORT).show();
                            }
                        });
        //Crear dialogo
        AlertDialog msgDlg = builder.create();
        //Mostrar dialogo
        msgDlg.show();
    }

    else{//S presiono el boton de dialogo con lista

            final AlertDialog dlgLista;
        //1
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //2
        builder.setTitle("Lista de colores")
                .setItems(R.array.color_names,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which){

                                Button btnPosDialog =((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                        switch (which){
                            case 0: //rojo
                            btnPosDialog.setBackgroundColor(Color.RED);
                            break;
                            case 1: //verde
                            btnPosDialog.setBackgroundColor(Color.GREEN);
                            break;
                            case 2://azul
                            btnPosDialog.setBackgroundColor(Color.BLUE);
                            break;
                            case 3://transparente
                            btnPosDialog.setBackgroundColor(Color.TRANSPARENT);
                            break;
                            default:{

                            }
                        }
                    }
                });
            //3
            dlgLista = builder.create();
            //4
            dlgLista.show();
    }


    }

    class lst implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int i){
            Toast.makeText(MainActivity.this, "Presione el boton aceptar", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDialogSimple = (Button) findViewById(R.id.btnDlgSimple);
        btnDialogSimple.setOnClickListener(this);

        Button btnDialogLista = (Button) findViewById(R.id.btnDlgLista);
        btnDialogLista.setOnClickListener(this);
    }
}
