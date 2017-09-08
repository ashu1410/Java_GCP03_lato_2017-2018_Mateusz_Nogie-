package com.example.ash.androidlogoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ash.androidlogoquiz.Adapter.GridViewAnswerAdapter;
import com.example.ash.androidlogoquiz.Adapter.GridViewSuggestAdapter;
import com.example.ash.androidlogoquiz.Common.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public List<String> suggestSource = new ArrayList<>();

    public GridViewAnswerAdapter answerAdapter;
    public GridViewSuggestAdapter suggestAdapter;

    public Button btnSubmit;

    public GridView gridViewAnswer,gridViewSuggest;

    public ImageView imgViewQuestion;

    int[] image_list={

            R.drawable.pogon,
            R.drawable.sandencja,
            R.drawable.slask,
            R.drawable.termalica,
            R.drawable.arka,
            R.drawable.cracovia,
            R.drawable.gornik,
            R.drawable.jagiellonia,
            R.drawable.korona,
            R.drawable.lech,
            R.drawable.lechia,
            R.drawable.legia,
            R.drawable.wisla,
            R.drawable.piast,
            R.drawable.petrochemia,
            R.drawable.zaglebie
    };

    public char[] answer;

    String correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void initView() {
        gridViewAnswer = (GridView)findViewById(R.id.gridViewAnswer);
        gridViewSuggest = (GridView)findViewById(R.id.gridViewSuggest);

        imgViewQuestion = (ImageView)findViewById(R.id.imgLogo);

        //wczytywanie listy
        setupList();

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result="";
                for(int i=0;i< Common.user_submit_answer.length;i++)
                    result+=String.valueOf(Common.user_submit_answer[i]);
                if(result.equals(correct_answer))
                {
                    Toast.makeText(getApplicationContext(),"CORRECT",Toast.LENGTH_SHORT).show();

                    //reset licznika i odpowiedzi
                    Common.count = 0;
                    Common.user_submit_answer = new char[correct_answer.length()];

                    //ustawiamy adaptery dla nastepnego
                    GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(setupNullList(),getApplicationContext());
                    gridViewAnswer.setAdapter(answerAdapter);
                    answerAdapter.notifyDataSetChanged();

                    GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(suggestSource,getApplicationContext(),MainActivity.this);
                    gridViewSuggest.setAdapter(suggestAdapter);
                    suggestAdapter.notifyDataSetChanged();

                    setupList();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Incorrect!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupList() {
        //losujemy random logo
        Random random = new Random();
        int imageSelected = image_list[random.nextInt(image_list.length)];
        imgViewQuestion.setImageResource(imageSelected);

        correct_answer = getResources().getResourceName(imageSelected);
        correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/")+1);

        answer = correct_answer.toCharArray();

        Common.user_submit_answer = new char[answer.length];

        //dodajemy literke do odpowiedzi
        suggestSource.clear();
        for(char item:answer)
        {
            //dodajemy nazwe logo do listy
            suggestSource.add(String.valueOf(item));
        }

        //dodawanie literek nie bedacych w nazwie, lub duplikatow
        for(int i = answer.length;i<answer.length*2;i++)
            suggestSource.add(Common.alphabet_character[random.nextInt(Common.alphabet_character.length)]);

        //przetasuj
        Collections.shuffle(suggestSource);

        //ustaw gridview
        answerAdapter = new GridViewAnswerAdapter(setupNullList(),this);
        suggestAdapter = new GridViewSuggestAdapter(suggestSource,this,this);

        answerAdapter.notifyDataSetChanged();
        suggestAdapter.notifyDataSetChanged();

        gridViewSuggest.setAdapter(suggestAdapter);
        gridViewAnswer.setAdapter(answerAdapter);


    }

    private char[] setupNullList() {
        char result[] = new char[answer.length];
        for(int i=0;i<answer.length;i++)
            result[i]=' ';
        return result;
    }
}