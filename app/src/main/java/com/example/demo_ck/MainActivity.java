package com.example.demo_ck;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.DatePickerDialog;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editTextDate;
    EditText editTextExpenseName;
    EditText editTextExpenseAmount;
    EditText editTextLocationName;
    Spinner spinnerExpenseCategory;
    SwitchCompat switchExpensePaid;
    Button buttonAddExpense;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ các thành phần trong layout
        editTextDate = findViewById(R.id.editTextDate);
        editTextExpenseName = findViewById(R.id.editTextExpenseName);
        editTextExpenseAmount = findViewById(R.id.editTextExpenseAmount);
        editTextLocationName = findViewById(R.id.editLocationName);
        spinnerExpenseCategory = findViewById(R.id.spinnerExpenseCategory);
        switchExpensePaid = findViewById(R.id.switchExpensePaid);
        buttonAddExpense = findViewById(R.id.buttonAddExpense);
        imageButton = findViewById(R.id.imageButton);
        // Đặt sự kiện click cho nút "Thêm"
        buttonAddExpense.setOnClickListener(view -> {
            // Lấy thông tin từ các trường nhập liệu
            String date = editTextDate.getText().toString();
            String expenseName = editTextExpenseName.getText().toString();
            String expenseAmount = editTextExpenseAmount.getText().toString();
            String LocationName = editTextLocationName.getText().toString();
            String expenseCategory = spinnerExpenseCategory.getSelectedItem().toString();
            boolean expensePaid = switchExpensePaid.isChecked();

            // Xử lý dữ liệu theo nhu cầu của ứng dụng

            // (ví dụ: lưu vào cơ sở dữ liệu, thực hiện các thao tác khác)

            // Hiển thị thông báo hoặc thực hiện các hành động khác
            Toast.makeText(MainActivity.this, "Đã thêm khoản chi phí: " + expenseName, Toast.LENGTH_SHORT).show();
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showimageButton();
            }
        });
    }

    private void showimageButton() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String selectedDateTxt = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                editTextDate.setText(selectedDateTxt);
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}


