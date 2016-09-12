package co.locarta.sdk.demo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import co.locarta.sdk.LocartaSdk;
import co.locarta.sdk.common.TermsStatus;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED) {
            showAgreementDialog();
        } else {
            askForPermission();
        }
    }

    /**
     * After getting a Manifest.permission.ACCESS_FINE_LOCATION for Android >= 23 you can display this
     * built-in dialog or simple call {@link LocartaSdk#setAgreementAccepted(Context, boolean)}. If you
     * want you can call those methods in right after user started the app. Locarta SDK supports permissions
     * and do not collect the data we don't have permission for.
     * <p/>
     * For Android SDK < 23 you don't need to ask permissions by yourself.
     */
    private void showAgreementDialog() {
        if (LocartaSdk.getAgreementStatus(this) != TermsStatus.ACCEPTED) {
            LocartaSdk.showAgreementDialog(this);
        }
    }

    private void askForPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(this, "We need a location permission to track your location for marketing research", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showAgreementDialog();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
