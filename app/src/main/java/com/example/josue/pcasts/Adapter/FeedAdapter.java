package com.example.josue.pcasts.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josue.pcasts.DetailActivity;
import com.example.josue.pcasts.Interface.ItemClickListener;
import com.example.josue.pcasts.Model.RSSObject;
import com.example.josue.pcasts.R;

/**
 * Created by josue on 03/01/2018.
 */


class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public TextView txtTitle, txtPubDate, txtContent;
    private ItemClickListener itemClickListener;

    public FeedViewHolder(View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtPubDate = itemView.findViewById(R.id.txtPubDate);
        txtContent = itemView.findViewById(R.id.txtContent);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }
}


public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private final Context mContext;
    private RSSObject rssObject;
    private LayoutInflater inflater;


    public FeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.row, parent, false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FeedViewHolder holder, int position) {

        holder.txtTitle.setText(rssObject.getItems().get(position).getTitle());
        holder.txtPubDate.setText(rssObject.getItems().get(position).getTitle());
        String tempContent = rssObject.getItems().get(position).getContent();
        tempContent = tempContent.replace("<p>", "");
        tempContent = tempContent.replace("</p>", "");
        holder.txtContent.setText(tempContent);


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!isLongClick){
                    Intent i = new Intent();
                    i.setClass(mContext, DetailActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("title", rssObject.getItems().get(position).getTitle());
                    i.putExtra("url", rssObject.getItems().get(position).enclosure.getLink());
                    i.putExtra("pubDate", rssObject.getItems().get(position).getPubDate());
                    String tempContent = rssObject.getItems().get(position).getContent();
                    tempContent = tempContent.replace("<p>", "");
                    tempContent = tempContent.replace("</p>", "");
                    i.putExtra("content", tempContent);
                    mContext.startActivity(i);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
