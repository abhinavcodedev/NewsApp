package com.example.abhinavnewsapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kwabenaberko.newsapilib.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.NewsViewHolder> {

    List<Article> articleList;

    RecyclerAdapter(List<Article>articleList){
        this.articleList= articleList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);
        return new NewsViewHolder(view);
    }

    void updateData(List<Article> data){
        articleList.clear();
        articleList.addAll(data);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Article article= articleList.get(position);
        holder.titletv.setText(article.getTitle());
        holder.sourcetv.setText(article.getSource().getName());
        Picasso.get().load(article.getUrlToImage())
                .error(R.drawable.no_image)
                .placeholder(R.drawable.no_image)
                .into(holder.imagev);

        holder.itemView.setOnClickListener((v->{
            Intent intent=new Intent(v.getContext(),Fullnew.class);
            intent.putExtra("url",article.getUrl());
            v.getContext().startActivity(intent);
        }));
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView titletv,sourcetv;
        ImageView imagev;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            titletv=itemView.findViewById(R.id.articleTitle);
            sourcetv=itemView.findViewById(R.id.articleSource);
            imagev=itemView.findViewById(R.id.article_image);
        }
    }
}
