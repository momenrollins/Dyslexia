package com.momen.dyslexia;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.pdfview.PDFView;

public class PDFActivity extends AppCompatActivity {

    private PDFView pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfactivity);
        initView();
        pdf.fromAsset("intro_file.pdf").show();
    }
    private void initView() {
        pdf = (PDFView) findViewById(R.id.pdf);
    }
}