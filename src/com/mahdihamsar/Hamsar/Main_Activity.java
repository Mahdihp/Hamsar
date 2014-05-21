package com.mahdihamsar.Hamsar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Dictionary;
import java.util.Hashtable;

public class Main_Activity extends Activity {
    /**
     * Called when the activity is first created.
     */

    Dictionary<Integer, String> dict = new Hashtable<Integer, String>();

    EditText txtMal;
    EditText txtFamel;

    Button btnResult;

    Button btnClearmal;
    Button btnClearfamel;

    TextView txtResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Fill_Char();

        txtMal = (EditText) findViewById(R.id.txt_Mal);
        txtFamel = (EditText) findViewById(R.id.txt_Famel);
        btnResult = (Button) findViewById(R.id.btn_Result);
        txtResult = (TextView) findViewById(R.id.txt_Result);

        btnClearmal = (Button) findViewById(R.id.btnClearMal);
        btnClearmal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMal.setText("");
            }
        });
        btnClearfamel = (Button) findViewById(R.id.btnClearFamel);
        btnClearfamel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFamel.setText("");
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (txtMal.getText().length() > 0 && txtFamel.length() > 0) {

                    String mal_name = txtMal.getText().toString();
                    String famel_name = txtFamel.getText().toString();

                    Compute(mal_name, famel_name);
                } else {
                    Toast.makeText(getApplicationContext(), "لطفا نام آقا و خانم را وارد کنید.", 2).show();
                }

            }
        });

    }

    private void Compute(String mal, String Famel) {
        long Res = 0;

        char[] mal_char = mal.toCharArray();
        char[] famel_char = Famel.toCharArray();

        System.out.println("-----------Size String:" + mal_char.length);
        System.out.println("-----------Size String:" + famel_char.length);


        for (int i = 0; i < mal_char.length; i++) {

            for (int j = 0; j < 28; j++) {

                if (Character.toString(mal_char[i]).equals(dictt[j][1])) {
                    Res += Long.parseLong(dictt[j][0]);
                }
            }
        }

        //---------------------------Famele ----------------------
        for (int i = 0; i < famel_char.length; i++) {

            for (int j = 0; j < 28; j++) {

                if (Character.toString(famel_char[i]).equals(dictt[j][1])) {
                    Res += Long.parseLong(dictt[j][0]);
                }
            }
        }


        long ress2 = Res;

        long ress = Res % 5;
        System.out.println(ress2 + "----Mod 5------Result ress:" + ress);
        System.out.println(((String) ("----Mod 2------Result ress:" + (ress % 2))));

        if (ress % 2 == 0) {
            txtResult.setText(" به هم می رسند. " + "\n" + "جمع ابجد کبیر: " + ress2);
        } else {
            txtResult.setText(" سرانجامی ندارد. " + "\n" + "جمع ابجد کبیر: " + ress2);
        }
    }

    String[][] dictt = new String[28][2];

    private void Fill_Char() {


        dictt[0][0] = "1";
        dictt[1][0] = "2";
        dictt[2][0] = "3";
        dictt[3][0] = "4";
        dictt[4][0] = "5";
        dictt[5][0] = "6";
        dictt[6][0] = "7";
        dictt[7][0] = "8";
        dictt[8][0] = "9";
        dictt[9][0] = "10";
        dictt[10][0] = "20";
        dictt[11][0] = "30";
        dictt[12][0] = "40";
        dictt[13][0] = "50";
        dictt[14][0] = "60";
        dictt[15][0] = "70";
        dictt[16][0] = "80";
        dictt[17][0] = "90";
        dictt[18][0] = "100";
        dictt[19][0] = "200";
        dictt[20][0] = "300";
        dictt[21][0] = "400";
        dictt[22][0] = "500";
        dictt[23][0] = "600";
        dictt[24][0] = "700";
        dictt[25][0] = "800";
        dictt[26][0] = "900";
        dictt[27][0] = "1000";
        //------------------------
        dictt[0][1] = "ا";
        dictt[1][1] = "ب";
        dictt[2][1] = "ج";
        dictt[3][1] = "د";
        dictt[4][1] = "ه";
        dictt[5][1] = "و";
        dictt[6][1] = "ز";
        dictt[7][1] = "ح";
        dictt[8][1] = "ط";
        dictt[9][1] = "ی";
        dictt[10][1] = "ک";
        dictt[11][1] = "ل";
        dictt[12][1] = "م";
        dictt[13][1] = "ن";
        dictt[14][1] = "س";
        dictt[15][1] = "ع";
        dictt[16][1] = "ف";
        dictt[17][1] = "ص";
        dictt[18][1] = "ق";
        dictt[19][1] = "ر";
        dictt[20][1] = "ش";
        dictt[21][1] = "ت";
        dictt[22][1] = "ث";
        dictt[23][1] = "خ";
        dictt[24][1] = "ذ";
        dictt[25][1] = "ض";
        dictt[26][1] = "ظ";
        dictt[27][1] = "غ";

    }
}
