package com.example.newsappjava.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsappjava.R;
import com.example.newsappjava.adapter.NewsAdapter;
import com.example.newsappjava.adapter.Utils;
import com.example.newsappjava.model.MainNews;
import com.example.newsappjava.model.ModelNews;
import com.example.newsappjava.network.ApiInterface;
import com.example.newsappjava.network.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    ArrayList<ModelNews> modelNewsArrayList;
    NewsAdapter adapter;
   // String country="in";
    private RecyclerView homeRecyclerView;
    private String category="in";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_home, null);

        homeRecyclerView=v.findViewById(R.id.homeRecyclerView);
        modelNewsArrayList=new ArrayList<>();
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new NewsAdapter(getContext(),modelNewsArrayList);
        homeRecyclerView.setAdapter(adapter);

        findViews();


        return v;
    }

    private void findViews() {
        ApiUtilities.getApiInterface().getNews(category,100, ApiInterface.API_KEY)
                .enqueue(new Callback<MainNews>() {
                    @Override
                    public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                        if (response.isSuccessful()){
                            modelNewsArrayList.addAll(response.body().getArticles());
                            adapter.notifyDataSetChanged();

                        }
                    }

                    @Override
                    public void onFailure(Call<MainNews> call, Throwable t) {

                    }
                });

    }
}