package com.example.newsappjava.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


public class SportsFragment extends Fragment {


    ArrayList<ModelNews> modelNewsArrayList;
    NewsAdapter adapter;
    // String country="in";
   private RecyclerView sportsRv;
    private String category="sports";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_sports, null);

        sportsRv=v.findViewById(R.id.sportsRV);
        modelNewsArrayList=new ArrayList<>();
        sportsRv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new NewsAdapter(getContext(),modelNewsArrayList);
        sportsRv.setAdapter(adapter);

        findViews();


        return v;
    }

    private void findViews() {
        ApiUtilities.getApiInterface().getCategory(Utils.getCountry(),category,100,ApiInterface.API_KEY)
                .enqueue(new Callback<MainNews>() {
                    @Override
                    public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                        if (response.isSuccessful()) {
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