package com.example.ktra2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ktra2.adapter.RecycleViewAdapter;
import com.example.ktra2.dal.SQLiteHelper;
import com.example.ktra2.model.Item;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText eTitle,eDes,eDate;
    RadioButton rt1,rt2,rs1,rs2,rs3;

    RadioGroup rg1,rg2;
    RecycleViewAdapter adapter;
    private String tinhTrang;
    private Boolean congTac;
    Button btUpdate,btCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        btCancel.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        eDate.setOnClickListener(this);
    }
    private void initView(){

        eTitle=findViewById(R.id.tvTitle);
        eDes=findViewById(R.id.tvDes);
        eDate=findViewById(R.id.tvDate);
//        rt1=findViewById(R.id.radio_1);
//        rt2=findViewById(R.id.radio_2);
//        rs1=findViewById(R.id.radio_s1);
//        rs2=findViewById(R.id.radio_s2);
//        rs3=findViewById(R.id.radio_s3);

        rg1=findViewById(R.id.rg1);
        rg2=findViewById(R.id.rg2);

        btUpdate=findViewById(R.id.btUpdate);
        btCancel=findViewById(R.id.btCancel);

    }
    public void onRBCongTacClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.congTac_1minh:
                if (checked){
                    congTac = false;
                }
                    break;
            case R.id.congTac_lamChung:
                if (checked){
                    congTac = true;
                }
                    break;
        }
    }

    public void onRBTinhTrangClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.tinhTrang_chuaXong:
                if (checked){
                    tinhTrang = "Chua xong";
                }
                break;
            case R.id.tinhTrang_daXong:
                if (checked){
                    tinhTrang = "Da xong";
                }
                break;
            case R.id.tinhTrang_dangLam:
                if (checked){
                    tinhTrang = "Dang lam";
                }
                break;
        }
    }

    public void onClick(View view) {
        if (view==eDate){

            final Calendar c=Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            int day=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog =new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    String date="";
                    //=month>9
                    if(m>8){
                        date=d+"/"+(m+1)+"/"+y;
                    }
                    else{
                        date=d+"/0"+(m+1)+"/"+y;
                    }
                    eDate.setText(date);
                }
            },year,month,day);
            dialog.show();
        }
        if (view==btCancel){
            finish();
        }
        if (view==btUpdate){
            String t=eTitle.getText().toString();
            String des=eDes.getText().toString();
            String d=eDate.getText().toString();
            if(!t.isEmpty()){
                Item i =new Item(t,des,d,tinhTrang,congTac);
                SQLiteHelper db=new SQLiteHelper(this);
                db.addItem(i);
                adapter.notifyDataSetChanged();
                finish();
            }
        }
    }

}