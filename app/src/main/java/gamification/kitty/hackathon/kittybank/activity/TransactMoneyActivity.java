package gamification.kitty.hackathon.kittybank.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.entity.Transaction;
import gamification.kitty.hackathon.kittybank.entity.User;
import gamification.kitty.hackathon.kittybank.request.TransactionRequestManagement;
import gamification.kitty.hackathon.kittybank.utils.Utils;

public class TransactMoneyActivity extends BaseActivity {
    private EditText etBalance;
    private EditText etReceiverAccount;
    private EditText etReceiverName;
    private EditText etMessage;
    private Button btnNext;
    private Button btnCancel;
    private TextView tvAccountFullName;
    private TextView tvAccountNumber;
    private TextView tvSpendableBalance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transact_money);
        etBalance = findViewById(R.id.input_balance);
        etReceiverAccount = findViewById(R.id.input_reveiver_account);
        etReceiverName = findViewById(R.id.input_receiver_name);
        etMessage = findViewById(R.id.input_message);
        btnNext = findViewById(R.id.btn_next);
        tvAccountFullName = findViewById(R.id.tvAccountFullName);
        tvSpendableBalance = findViewById(R.id.tvAccountSpendable);
        tvAccountNumber = findViewById(R.id.tvAccountBalance);
        User user = Utils.getUserFromSharedPreference(this);
        tvAccountFullName.setText(user.getFullName());
        tvSpendableBalance.setText(new DecimalFormat("#,###.##").format(user.getBalance()) + " VND");
        tvAccountNumber.setText(user.getAccountNumber());
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user = Utils.getUserFromSharedPreference(getApplicationContext());
                final float balance = Float.parseFloat(etBalance.getText().toString());
                if (balance >= user.getBalance()){
                    Toast.makeText(getApplicationContext(), "Số dư khả dụng không đủ. Giao dịch không thành công", Toast.LENGTH_LONG).show();
                } else {
                    new AlertDialog.Builder(TransactMoneyActivity.this)
                            .setTitle("Xác nhận")
                            .setMessage("Xác nhận giao dịch")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int whichButton) {
                                    float balance = Float.parseFloat(etBalance.getText().toString());
                                    String senderAccount = user.getAccountNumber();
                                    int creditPoint = (int) (balance * 0.001);
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                    Date date = new Date();
                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                                    String message = etMessage.getText().toString();
                                    String receiverAccount = etReceiverAccount.getText().toString();
                                    String receiverName = etReceiverName.getText().toString();
                                    int typeId = 1;
                                    Transaction transaction = new Transaction(senderAccount, receiverAccount, receiverName, balance, sqlDate, typeId, message, creditPoint);
                                    TransactionRequestManagement trm = new TransactionRequestManagement(getApplicationContext());
                                    trm.updateTransaction(new IVolleyCallback() {
                                        @Override
                                        public void onSuccess(String result) {
                                            Toast.makeText(getApplicationContext(), "Giao dịch thành công", Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(TransactMoneyActivity.this, TransactActivity.class));
                                        }

                                        @Override
                                        public void onFailure(String message) {
                                            Toast.makeText(getApplicationContext(), "Giao dịch thất bại", Toast.LENGTH_LONG).show();
                                        }
                                    }, transaction);

                                }
                            })
                            .setNegativeButton(android.R.string.no, null).show();
                }
            }
        });
        btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TransactMoneyActivity.this, TransactActivity.class));
            }
        });
    }
}
