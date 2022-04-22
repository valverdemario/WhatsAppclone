package com.meva.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;
import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity {
    MaterialButton mbLogin;
    TextInputEditText etPhone;
    CountryCodePicker edCcp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getData();
            }
        });
    }

    private void getData(){
        String phone = etPhone.getText().toString();
        String code = edCcp.getSelectedCountryCodeWithPlus().toString();
        if(!phone.equals("")){
                           /* Intent i = new Intent(MainActivity.this,CodeVerificationActivity.class);
                startActivity(i, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());*/
        }else{
            Alerter.create(this).setTitle("Error").setText("Ingresa un número de teléfono valido").setBackgroundColorRes(R.color.black).setTextAppearance(R.style.textAlert)
                    .show();
        }
    }

    private void init(){
        mbLogin = findViewById(R.id.mBtnLogin);
        etPhone = findViewById(R.id.etPhone);
        edCcp = findViewById(R.id.edCcp);
    }
}