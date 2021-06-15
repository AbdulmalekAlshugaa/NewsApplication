package com.example.myapplication.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.MainFragmentBinding;
import com.example.myapplication.databinding.SearchArticleBinding;
import com.example.myapplication.model.article.ArticleResponse;
import com.example.myapplication.viewModel.ArticleListViewModel;

import java.util.HashMap;
import java.util.Objects;

import io.reactivex.disposables.CompositeDisposable;

public class SearchArticle extends Fragment {
    private View view;
    private SearchArticleBinding binding;
    // init article view model
    private ArticleListViewModel articleListViewModel;
    private CompositeDisposable mCompositeDisposable;
    private static final String TAG = "SearchArticle";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding  = SearchArticleBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        view = binding.getRoot();
        binding.progressBar.setVisibility(View.INVISIBLE);
        // init
        articleListViewModel = new ViewModelProvider(this).get(ArticleListViewModel.class);
        mCompositeDisposable = new CompositeDisposable();

        binding.searchButton.setOnClickListener(v -> {
         String searchText = Objects.requireNonNull(binding.articleSearchByEditText.getText()).toString();
            observeArticlesData(searchText);

        });
        return view;
    }

    private void observeArticlesData(String filteringType) {

        HashMap<String, Object> searchingParams = new HashMap<>();
        searchingParams.put("q",filteringType);


        articleListViewModel.getAllTheArticles(mCompositeDisposable,1,searchingParams)
                .observe(this, articleResponse -> {
                    Log.d(TAG, "observeArticlesData: "+articleResponse.getResponse().getDocs().get(0).getSource());

                });

    }
}
