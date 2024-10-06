package br.edu.fateczl.calc_area_trapezio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etBaseMenor;

    private EditText etBaseMaior;

    private EditText etAltura;

    private TextView tvRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBaseMenor = findViewById(R.id.etBaseMenor);
        etBaseMenor.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etBaseMaior = findViewById(R.id.etBaseMaior);
        etBaseMaior.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etAltura = findViewById(R.id.etAltura);
        etAltura.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc() {
        tvRes.setText("");
        int bMenor = Integer.parseInt(etBaseMenor.getText().toString());
        int bMaior = Integer.parseInt(etBaseMaior.getText().toString());
        int alt = Integer.parseInt(etAltura.getText().toString());
        int resp = ((bMenor + bMaior)*alt)/2;
        String res = getString(R.string.resp) + " " + resp;
        tvRes.setText(res);              //forma de colocar texto no TextView ou no EditText
    }
}