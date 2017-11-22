package nyc.c4q.whatismyaddress;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yokilam on 11/21/17.
 */

public class EmailAdapter extends RecyclerView.Adapter<EmailViewHolder>{


    List<Email> emailList;

    public EmailAdapter(List<Email> emailList) {
        this.emailList = emailList;
    }

    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.email_itemview, parent, false);

        return new EmailViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(EmailViewHolder holder, int position) {
        Email email = emailList.get(position);
        holder.bind(email);

    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }
}
