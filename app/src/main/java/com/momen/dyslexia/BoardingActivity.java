package com.momen.dyslexia;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class BoardingActivity extends AppCompatActivity {
    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicator;
    private MaterialButton buttonOnboardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarding);
        layoutOnboardingIndicator = findViewById(R.id.layoutOnboardingIndicators);
        buttonOnboardingAction = findViewById(R.id.buttonOnBoardingAction);
        setOnboardingItem();
        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);
        setOnboadingIndicator();
        setCurrentOnboardingIndicators(0);
        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicators(position);
            }
        });
        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()) {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void setOnboadingIndicator() {
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicator.addView(indicators[i]);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setCurrentOnboardingIndicators(int index) {
        int childCount = layoutOnboardingIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutOnboardingIndicator.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicator_inactive));
            }
        }
        if (index == onboardingAdapter.getItemCount() - 1) {
            buttonOnboardingAction.setText("Start");
        } else {
            buttonOnboardingAction.setText("Next");
        }
    }

    private void setOnboardingItem() {
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();
        OnBoardingItem firstBoardingItem = new OnBoardingItem();
        firstBoardingItem.setTitle("صعوبات التعلم اضطراب يعيق عملية التعلم الطبيعية، وهذا الاضطراب يكون في العمليات التي تدخل في عملية التعلم مثل الذاكرة والإدراك والانتباه والتفكير واستراتيجيات التعلم");
        firstBoardingItem.setDescription("");
        OnBoardingItem secondBoardingItem = new OnBoardingItem();
        secondBoardingItem.setTitle("أنواع صعوبات التعلم");
        secondBoardingItem.setDescription
                ("1. صعوبات التعلم النمائية: تتقسم الى:\nأ. الصعوبات الأولية: وتضم الانتباه والذاكرة والإدراك.\n" +
                "ب. الصعوبات الثانوية: وتضم التفكير واللغة الشفهية.\n2- صعوبات التعلم الأكاديمي \nأ. صعوبات القراءة: \n" +
                "ب- صعوبات الكتابة: \n" +
                "ج- صعوبات الرياضيات (الحساب): \n" +
                "د- صعوبات خاصة بالتهجئة والتعبير الكتابي:\nعسر القراءة \n" +
                "هي صعوبة تعلّم خاصّة، تؤثر على تطوُّر القراءة، والكتابة، والمهارات المتعلّقة بها\n");
        OnBoardingItem thirdBoardingItem = new OnBoardingItem();
        thirdBoardingItem.setTitle("من أفضل اختبارات تشخيص عسر القراءة – الديسلكسيا");
        thirdBoardingItem.setDescription("1- اختبار رون دفيس\n2- إختبار برنامج دوري\n" +
                "3- اختبار مؤسسة lexercise\n" +
                "4- اختبار dynaread\n" +
                "5- اختبار Bristol");
        onBoardingItems.add(firstBoardingItem);
        onBoardingItems.add(secondBoardingItem);
        onBoardingItems.add(thirdBoardingItem);
        onboardingAdapter = new OnboardingAdapter(onBoardingItems);
    }
}