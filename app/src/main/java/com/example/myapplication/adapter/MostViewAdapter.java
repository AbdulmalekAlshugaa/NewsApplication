package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ArticleItemBinding;
import com.example.myapplication.model.article.mostView.ResultsItem;

import java.util.ArrayList;

public class MostViewAdapter extends RecyclerView.Adapter<MostViewAdapter.ViewHolder> {
    private Context mContext;
    private final ArrayList<ResultsItem> mostViewArticles;

    public MostViewAdapter(Context mContext, ArrayList<ResultsItem> mostViewArticles) {
        this.mContext = mContext;
        this.mostViewArticles = mostViewArticles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.articleItemBinding.title.setText(mostViewArticles.get(position).getTitle());
        holder.articleItemBinding.description.setText(mostViewArticles.get(position).getPublishedDate());
    }

    @Override
    public int getItemCount() {
        return mostViewArticles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ArticleItemBinding articleItemBinding;

        public ViewHolder(ArticleItemBinding itemView) {
            super(itemView.getRoot());
            this.articleItemBinding = itemView;

        }
    }
}
