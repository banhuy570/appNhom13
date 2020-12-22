package com.example.docbaocuoiki.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.docbaocuoiki.HomeActivity;
import com.example.docbaocuoiki.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener, FirebaseAuth.AuthStateListener {
    Button btnDangNhapGoogle133;
    Button btnDangNhapFacebook133;
    Button btnDangNhap133;
    TextView txtDangKyMoi133, txtQuenMatKhau133;
    EditText edEmail, edPassword;

    GoogleApiClient apiClient;
    public static int REQUESTCODE_DANGNHAP_GOOGLE = 99;
    public static int KIEMTRA_PROVIDER_DANGNHAP = 0;
    FirebaseAuth firebaseAuth133;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth133 = FirebaseAuth.getInstance();
        firebaseAuth133.signOut();

        btnDangNhapGoogle133 = (Button) findViewById(R.id.btnDangNhapGoogle133);
        btnDangNhapFacebook133 = (Button) findViewById(R.id.btnDangNhapFacebook133);
        txtDangKyMoi133 = (TextView) findViewById(R.id.txtDangKyMoi133);
        txtQuenMatKhau133 = (TextView) findViewById(R.id.txtQuenMatKhau133);
        btnDangNhap133 = (Button) findViewById(R.id.btnDangNhap133);
        edEmail = (EditText) findViewById(R.id.edEmailDN);
        edPassword = (EditText) findViewById(R.id.edPasswordDN);

        btnDangNhapGoogle133.setOnClickListener(this);
        btnDangNhapFacebook133.setOnClickListener(this);
        txtDangKyMoi133.setOnClickListener(this);
        txtQuenMatKhau133.setOnClickListener(this);
        btnDangNhap133.setOnClickListener(this);

        TaoClientDangNhapGoogle();
    }

    private void TaoClientDangNhapGoogle() {
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder()
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        apiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions)
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth133.addAuthStateListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth133.removeAuthStateListener(this);
    }

    private void DangNhapGoogle(GoogleApiClient apiClient) {
        KIEMTRA_PROVIDER_DANGNHAP = 1;
        Intent iDNGoogle = Auth.GoogleSignInApi.getSignInIntent(apiClient);
        startActivityForResult(iDNGoogle, REQUESTCODE_DANGNHAP_GOOGLE);
    }

    private void ChungThucDangNhapFireBase(String tokenID) {
        if (KIEMTRA_PROVIDER_DANGNHAP == 1) {
            AuthCredential authCredential = GoogleAuthProvider.getCredential(tokenID, null);
            firebaseAuth133.signInWithCredential(authCredential);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE_DANGNHAP_GOOGLE) {
            if (resultCode == RESULT_OK) {
                GoogleSignInResult signInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                GoogleSignInAccount account = signInResult.getSignInAccount();
                String tokenID = account.getIdToken();
                ChungThucDangNhapFireBase(tokenID);
            } else {

            }
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnDangNhapGoogle133:
                DangNhapGoogle(apiClient);
                break;

            case R.id.btnDangNhapFacebook133:
                break;

            case R.id.txtDangKyMoi133:
                break;

            case R.id.btnDangNhap133:
                Intent iTrangChu = new Intent(this, HomeActivity.class);
                startActivity(iTrangChu);

                break;

            case R.id.txtQuenMatKhau133:

                break;
        }

    }

    private void DangNhap() {
        String email = edEmail.getText().toString();
        String matkhau = edPassword.getText().toString();
        firebaseAuth133.signInWithEmailAndPassword(email, matkhau).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(Login.this, "Tai Khoan Khong Hop le", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {

            //   SharedPreferences.Editor editor = sharedPreferences.edit();
            //   editor.putString("mauser", user.getUid());
            //   editor.apply();

            Intent iTrangChu = new Intent(this, HomeActivity.class);
            startActivity(iTrangChu);
        } else {

        }
    }
}