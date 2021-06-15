package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ArticleItemBinding;
import com.example.myapplication.model.article.articles.Articles;
import com.example.myapplication.model.article.articles.DocsItem;

import java.text.ParseException;
import java.util.ArrayList;

import static com.example.myapplication.utilities.Constants.publishDataConverting;

public class SearchArticlesAdapter  extends RecyclerView.Adapter<SearchArticlesAdapter.ViewHolder> {
    private Context mContext;
    private final ArrayList<DocsItem> articleResponseArrayList;

    public SearchArticlesAdapter(Context mContext, ArrayList<DocsItem> articleResponseArrayList) {
        this.mContext = mContext;
        this.articleResponseArrayList = articleResponseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.articleItemBinding.title.setText(articleResponseArrayList.get(position).getJsonMemberAbstract());
        try {
            holder.articleItemBinding.description.setText(publishDataConverting(articleResponseArrayList.get(position).getPubDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return articleResponseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ArticleItemBinding articleItemBinding;

        public ViewHolder(ArticleItemBinding itemView) {
            super(itemView.getRoot());
            this.articleItemBinding = itemView;

        }
    }
}
