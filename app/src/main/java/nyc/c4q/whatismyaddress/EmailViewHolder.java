package nyc.c4q.whatismyaddress;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yokilam on 11/21/17.
 */

class EmailViewHolder extends RecyclerView.ViewHolder{
    private TextView emailTextView;

    public EmailViewHolder(final View itemView) {
        super(itemView);
        emailTextView = (TextView) itemView.findViewById(R.id.textView);

        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DisplayActivity.class);
                intent.putExtra("email", emailTextView.getText().toString());
                startActivity(intent);
            }
        });

    }

    public void bind(Email email) {
        emailTextView.setText(email.getEmail());

    }


}
