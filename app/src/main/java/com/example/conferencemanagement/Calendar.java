package com.example.conferencemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Calendar extends AppCompatActivity {
    public String fname = null;
    public String fname2 = null;
    public String fname3 = null;
    public String fname4 = null;
    public String fname5 = null;
    public String fname6 = null;
    public String fname7 = null;

    public String str1 = null;
    public String str2 = null;
    public String str3 = null;
    public String str4 = null;
    public String str5 = null;
    public String str6 = null;
    public String str7 = null;
    public CalendarView calendarView;
    public Button btnsave, btncha, btndel, btnback;
    public TextView textdate, texttime, textmember, textreason, textcont, textnextc, textnextd;
    public EditText editdate, edittime, editmember, editreason, editcont, editnextc, editnextd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarView = findViewById(R.id.calendarView);
        btnsave = findViewById(R.id.btnsave);
        btncha = findViewById(R.id.btncha);
        btndel = findViewById(R.id.btndel);
        btnback = findViewById(R.id.btnback);
        textdate = findViewById(R.id.textdate);
        texttime = findViewById(R.id.texttime);
        textmember = findViewById(R.id.textmember);
        textreason = findViewById(R.id.textreason);
        textcont = findViewById(R.id.textcont);
        textnextc = findViewById(R.id.textnextc);
        textnextd = findViewById(R.id.textnextd);

        editdate = findViewById(R.id.editdate);
        edittime = findViewById(R.id.edittime);
        editmember = findViewById(R.id.editmember);
        editreason = findViewById(R.id.editreason);
        editcont = findViewById(R.id.editcont);
        editnextc = findViewById(R.id.editnextc);
        editnextd = findViewById(R.id.editnextd);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { //켈린더 출력
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {//켈린더 날짜 선택
                editdate.setText("");
                edittime.setText("");
                editmember.setText("");
                editreason.setText("");
                editcont.setText("");
                editnextc.setText("");
                editnextd.setText("");


                checkDay(year, month, dayOfMonth);

            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() { //저장버튼
            @Override
            public void onClick(View view) {
                saveDiary(fname);
                saveDiary2(fname2);
                saveDiary3(fname3);
                saveDiary4(fname4);
                saveDiary5(fname5);
                saveDiary6(fname6);
                saveDiary7(fname7);

                str1 = editdate.getText().toString();
                editdate.setText(str1);

                str2 = edittime.getText().toString();
                edittime.setText(str2);

                str3 = editmember.getText().toString();
                editmember.setText(str3);

                str4 = editreason.getText().toString();
                editreason.setText(str4);

                str5 = editcont.getText().toString();
                editcont.setText(str5);

                str6 = editnextc.getText().toString();
                editnextc.setText(str6);

                str7 = editnextd.getText().toString();
                editnextd.setText(str7);

            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), room.class);
                startActivity(intent);
            }
        });

    }



    public void checkDay(int cYear, int cMonth, int cDay) {
        fname = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";
        fname2 = "2" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";
        fname3 = "3" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";
        fname4 = "4" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";
        fname5 = "5" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";
        fname6 = "6" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";
        fname7 = "7" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";


        FileInputStream fis = null;
        FileInputStream fis2 = null;
        FileInputStream fis3 = null;
        FileInputStream fis4 = null;
        FileInputStream fis5 = null;
        FileInputStream fis6 = null;
        FileInputStream fis7 = null;


        try {
            fis = openFileInput(fname);
            fis2 = openFileInput(fname2);
            fis3 = openFileInput(fname3);
            fis4 = openFileInput(fname4);
            fis5 = openFileInput(fname5);
            fis6 = openFileInput(fname6);
            fis7 = openFileInput(fname7);


            byte[] fileDate = new byte[fis.available()];
            fis.read(fileDate);
            fis.close();
            byte[] fileDate2 = new byte[fis2.available()];
            fis2.read(fileDate2);
            fis2.close();
            byte[] fileDate3 = new byte[fis3.available()];
            fis3.read(fileDate3);
            fis3.close();
            byte[] fileDate4 = new byte[fis4.available()];
            fis4.read(fileDate4);
            fis4.close();
            byte[] fileDate5 = new byte[fis5.available()];
            fis5.read(fileDate5);
            fis5.close();
            byte[] fileDate6 = new byte[fis6.available()];
            fis6.read(fileDate6);
            fis6.close();
            byte[] fileDate7 = new byte[fis7.available()];
            fis7.read(fileDate7);
            fis7.close();

            str1 = new String(fileDate);
            editdate.setText(str1);

            str2 = new String(fileDate2);
            edittime.setText(str2);

            str3 = new String(fileDate3);
            editmember.setText(str3);

            str4 = new String(fileDate4);
            editreason.setText(str4);

            str5 = new String(fileDate5);
            editcont.setText(str5);

            str6 = new String(fileDate6);
            editnextc.setText(str6);

            str7 = new String(fileDate7);
            editnextd.setText(str7);

            btncha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveDiary(fname);
                    saveDiary2(fname2);
                    saveDiary3(fname3);
                    saveDiary4(fname4);
                    saveDiary5(fname5);
                    saveDiary6(fname6);
                    saveDiary7(fname7);

                    str1 = editdate.getText().toString();
                    editdate.setText(str1);

                    str2 = edittime.getText().toString();
                    edittime.setText(str2);

                    str3 = editmember.getText().toString();
                    editmember.setText(str3);

                    str4 = editreason.getText().toString();
                    editreason.setText(str4);

                    str5 = editcont.getText().toString();
                    editcont.setText(str5);

                    str6 = editnextc.getText().toString();
                    editnextc.setText(str6);

                    str7 = editnextd.getText().toString();
                    editnextd.setText(str7);
                }
            });
            btndel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editdate.setText("");

                    edittime.setText("");

                    editmember.setText("");

                    editreason.setText("");

                    editcont.setText("");

                    editnextc.setText("");

                    editnextd.setText("");
                    removeDiary(fname);
                    removeDiary(fname2);
                    removeDiary(fname3);
                    removeDiary(fname4);
                    removeDiary(fname5);
                    removeDiary(fname6);
                    removeDiary(fname7);
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressLint("WrongConstant")
    public void removeDiary(String readDay) {
        FileOutputStream fos = null;
        FileOutputStream fos2 = null;
        FileOutputStream fos3 = null;
        FileOutputStream fos4 = null;
        FileOutputStream fos5 = null;
        FileOutputStream fos6 = null;
        FileOutputStream fos7 = null;

        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = "";
            fos.write((content).getBytes());
            fos.close();
            fos2= openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content2 = "";
            fos2.write((content2).getBytes());
            fos2.close();
            fos3 = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content3 = "";
            fos3.write((content3).getBytes());
            fos3.close();
            fos4 = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content4 = "";
            fos4.write((content4).getBytes());
            fos4.close();
            fos5 = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content5 = "";
            fos5.write((content5).getBytes());
            fos5.close();
            fos6 = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content6 = "";
            fos6.write((content6).getBytes());
            fos6.close();
            fos7 = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content7 = "";
            fos7.write((content7).getBytes());
            fos7.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressLint("WrongConstant")
    public void saveDiary(String readDay) {
        FileOutputStream fos = null;


        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);

            String content = editdate.getText().toString();


            fos.write((content).getBytes());



            fos.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @SuppressLint("WrongConstant")
    public void saveDiary2(String readDay) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = edittime.getText().toString();
            fos.write((content).getBytes());
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressLint("WrongConstant")
    public void saveDiary3(String readDay) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = editmember.getText().toString();
            fos.write((content).getBytes());
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressLint("WrongConstant")
    public void saveDiary4(String readDay) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = editreason.getText().toString();
            fos.write((content).getBytes());
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressLint("WrongConstant")
    public void saveDiary5(String readDay) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = editcont.getText().toString();
            fos.write((content).getBytes());
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressLint("WrongConstant")
    public void saveDiary6(String readDay) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = editnextc.getText().toString();
            fos.write((content).getBytes());
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @SuppressLint("WrongConstant")
    public void saveDiary7(String readDay) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = editnextd.getText().toString();
            fos.write((content).getBytes());
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}