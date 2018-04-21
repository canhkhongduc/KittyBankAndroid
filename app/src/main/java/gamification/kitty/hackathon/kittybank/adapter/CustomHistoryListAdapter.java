package gamification.kitty.hackathon.kittybank.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import gamification.kitty.hackathon.kittybank.R;
import gamification.kitty.hackathon.kittybank.activity.TransactActivity;
import gamification.kitty.hackathon.kittybank.entity.Transaction;
import gamification.kitty.hackathon.kittybank.entity.User;

/**
 * Created by Khổng Cảnh on 4/21/2018.
 */

public class CustomHistoryListAdapter extends RecyclerView.Adapter<HistoryViewHolder> {
    private Context context;
    private List<Transaction> data;
    private User user;

    public CustomHistoryListAdapter(Context context, List<Transaction> data, User user) {
        this.context = context;
        this.data = data;
        this.user = user;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_cardview, parent,false);
        return new HistoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        Transaction transaction = data.get(position);
        if (transaction.getSenderAccount().equals(user.getAccountNumber())){
            holder.transactionDetail.setText("Bạn đã gửi cho" + transaction.getReceiverName());
            holder.transactionBalance.setText(transaction.getBalance()+ " VND");
            holder.transactionDate.setText(transaction.getDate().toString());
            holder.balanceStatus.setImageResource(R.drawable.down);
        } else if (transaction.getReceiverAccount().equals( user.getAccountNumber())){
            holder.transactionDetail.setText("Bạn đã nhận từ" + transaction.getReceiverName());
            holder.transactionBalance.setText(transaction.getBalance()+ " VND");
            holder.transactionDate.setText(transaction.getDate().toString());
            holder.balanceStatus.setImageResource(R.drawable.up);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
