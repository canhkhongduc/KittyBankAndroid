package gamification.kitty.hackathon.kittybank.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import gamification.kitty.hackathon.kittybank.R;

/**
 * Created by Khổng Cảnh on 4/21/2018.
 */

public class HistoryViewHolder extends RecyclerView.ViewHolder {
    public TextView transactionDetail;
    public TextView transactionBalance;
    public TextView transactionDate;
    public ImageView balanceStatus;

    public HistoryViewHolder(View itemView) {
        super(itemView);
        transactionDetail = (TextView) itemView.findViewById(R.id.tvTransactionDetail);
        transactionBalance = (TextView) itemView.findViewById(R.id.tvTransactionBalance);
        transactionDate = (TextView) itemView.findViewById(R.id.tvTransactionDate);
        balanceStatus = (ImageView) itemView.findViewById(R.id.ivBalanceStatus);
    }
}
