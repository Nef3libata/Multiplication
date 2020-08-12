package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int wordStr;

    TextView resultTextView;
    EditText answerText;
    ImageView imageView;
    Random r;

    Integer[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img8, R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12, R.drawable.img13, R.drawable.img14, R.drawable.img15, R.drawable.img16, R.drawable.img17, R.drawable.img18, R.drawable.img19, R.drawable.img20, R.drawable.img21, R.drawable.img22, R.drawable.img21, R.drawable.img23, R.drawable.img24, R.drawable.img25, R.drawable.img26, R.drawable.img27, R.drawable.img28, R.drawable.img29, R.drawable.img30, R.drawable.img31, R.drawable.img32, R.drawable.img33, R.drawable.img34, R.drawable.img35, R.drawable.img36, R.drawable.img37, R.drawable.img38, R.drawable.img39, R.drawable.img40, R.drawable.img41, R.drawable.img42, R.drawable.img43, R.drawable.img44, R.drawable.img45, R.drawable.img46, R.drawable.img47};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.newBtn).setOnClickListener(buttonClickListener);
        findViewById(R.id.check).setOnClickListener(buttonClickListener);
        generateRandomM();
    }

    public String rnBravo() {
        Random rand = new Random();
        List<String> givenList = Arrays.asList("آفرين بهت!","آفــــــرين!","آفرين!","کاملا درسته!","بازم درست گفتی!","نابغه ای!","درود فراوان!","آفرين زرنگ!","يک دسته گل بزرگ تقديم به شما!","وصفت چگونه گويم کان در زبان نگنجد!","صد آفرين!","درود بر تو!","رياضيت خوبه‌ها!","بزرگ ترين رياضی‌دان تاريخی!","تو بهترينی!","آفرين باهوش!!","چه زرنگی","درسته!","نمرت بيسته!","خيلی خوبه!","هرچی بگم کمه!","هزار و سيصد آفرين!"
 );

        int randomIndex = rand.nextInt(givenList.size());
        String randomBravo = givenList.get(randomIndex);
        return randomBravo;

    }

    public void generateRandomM(){

        Random random = new Random();
        int max = 10;
        int min = 2;
        TextView randomText = (TextView) findViewById(R.id.randomText);
        int num1 = random.nextInt(max - min + 1) + min;
        int num2 = random.nextInt(max - min + 1) + min;
        wordStr = num1 * num2;
        randomText.setText(num1 + " " +  "X" + " " + num2);

    }


    private  View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.check:

                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);

                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);

                    String result = null;
                    answerText = (EditText) findViewById(R.id.answer);
                    resultTextView = (TextView) findViewById(R.id.result);

                    r = new Random();

                    int answer = Integer.parseInt(answerText.getText().toString());

                    if (wordStr == answer) {
                        result = rnBravo();
                        imageView = (ImageView) findViewById(R.id.img);
                        imageView.setImageResource(images[r.nextInt(images.length)]);

                    } else if(wordStr != answer){
                        result = "بیشتر دقت کن! جواب درست:" + " " + wordStr;
                    } else if (TextUtils.isEmpty(answerText.getText().toString())) {
                        result = "هنوز جواب ندادی که!";
                    }

                    resultTextView.setText(result + " ");
                    break;

                case R.id.newBtn:

                    resultTextView.setText("");
                    answerText.setText("");
                    imageView.setImageBitmap(null);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,0);

                    generateRandomM();

            }
        }


    };
}