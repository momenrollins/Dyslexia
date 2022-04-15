package com.momen.dyslexia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LettersImages extends AppCompatActivity {
    int[] images = {R.drawable.s1, R.drawable.s2,
            R.drawable.s3, R.drawable.s4, R.drawable.s5,
            R.drawable.s6, R.drawable.s7, R.drawable.s8,
            R.drawable.s9, R.drawable.s10, R.drawable.s1111,
            R.drawable.s12, R.drawable.s13, R.drawable.s16,
            R.drawable.s17, R.drawable.s14,
            R.drawable.s15,
            R.drawable.s18, R.drawable.s19, R.drawable.s20,
            R.drawable.s21, R.drawable.s220, R.drawable.s23,
            R.drawable.s24, R.drawable.s25, R.drawable.s26,
            R.drawable.s27, R.drawable.s28,
    };

    int[] right_images = {R.drawable.s11, R.drawable.s22,
            R.drawable.s33, R.drawable.s44, R.drawable.s55,
            R.drawable.s66, R.drawable.s77, R.drawable.s88,
            R.drawable.s99, R.drawable.s101, R.drawable.s11111,
            R.drawable.s121, R.drawable.s131, R.drawable.s161,
            R.drawable.s171, R.drawable.s141,
            R.drawable.s151,
            R.drawable.s181, R.drawable.s191, R.drawable.s201,
            R.drawable.s211, R.drawable.s2201, R.drawable.s231,
            R.drawable.s241, R.drawable.s251, R.drawable.s261,
            R.drawable.s271, R.drawable.s281,
    };

    int[] left_images = {R.drawable.s111, R.drawable.s222,
            R.drawable.s333, R.drawable.im_4_2, R.drawable.s555,
            R.drawable.s666, R.drawable.s777, R.drawable.s888,
            R.drawable.s999, R.drawable.s1011, R.drawable.s111111,
            R.drawable.s1211, R.drawable.s1311, R.drawable.s1611,
            R.drawable.s1711, R.drawable.s1411,
            R.drawable.s1511,
            R.drawable.s1811, R.drawable.s1911, R.drawable.s2011,
            R.drawable.s2111, R.drawable.s2202, R.drawable.s311,
            R.drawable.s2411, R.drawable.s2511, R.drawable.s2611,
            R.drawable.s2711, R.drawable.s2811,
    };
    String[] names = {"أ / ارنب / اسد ", "ب / باب / بطة", "ت / تفاح / توت ", "ث / ثعبان / ثور ", "ج / جزر / جمل ", "ح / حصان / حمامة ",
            "خ / خيار / خوخ ", "د / ديك / دراجة ", "ذ / ذرة / ذبابة ", "ر / رمان / ريشة ", "ز / زرافة / زيتون ",
            "س / سمك / ساعة", "ش / شجرة/ شباك ", "ص / صقر / صندوق", "ض / ضفدع / ضبع ", "ط / طماطم / طيارة", "ظ/ ظرف / ظابط ", "ع / عجلة/ عنب ",
            "غ غزالة/ غسالة", "ف / فراولة/ فراشة", "ق / قمر / قمح ", "ك / كلب / كرسي ",
            "ل / لمون / لبن ", "م / موز / مشمش ", "ن / نحلة/ نخلة", "ه / هدية/ هدهد ", "واو / وردة/ ولد ", "ي / يد / يمامة",};

    int[] lettersSounds = {};
    private RecyclerView rvWords;
    private LettersImagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_images);
        initView();
        rvWords.setLayoutManager(new CenterZoomLayoutManager(this));
        adapter = new LettersImagesAdapter(images, right_images, left_images, names,lettersSounds, this);
        rvWords.setAdapter(adapter);

    }

    private void initView() {
        rvWords = (RecyclerView) findViewById(R.id.rv_words);
    }
}