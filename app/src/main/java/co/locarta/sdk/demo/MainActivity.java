package co.locarta.sdk.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.locarta.sdk.LocartaSdk;
import co.locarta.sdk.common.TermsStatus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (LocartaSdk.getAgreementStatus(this) != TermsStatus.ACCEPTED){
            LocartaSdk.showAgreementDialog(this);
        }
    }
}
