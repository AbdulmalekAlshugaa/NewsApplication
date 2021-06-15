package com.example.myapplication.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.myapplication.R;
import com.example.myapplication.adapter.SearchArticlesAdapter;
import com.example.myapplication.databinding.SearchArticleBinding;
import com.example.myapplication.model.article.articles.Articles;
import com.example.myapplication.model.article.articles.DocsItem;
import com.example.myapplication.viewModel.ArticleListViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import io.reactivex.disposables.CompositeDisposable;

public class SearchArticle extends Fragment {
    private View view;
    private SearchArticleBinding binding;
    // init article view model
    private ArticleListViewModel articleListViewModel;
    private CompositeDisposable mCompositeDisposable;
    private final ArrayList<DocsItem> mMovieResponseArrayList = new ArrayList<>();
    private static final String TAG = "SearchArticle";
    private SearchArticlesAdapter mCompanyProductionAdapter; // Adapter
    private int currentPage = 1;
    private int totalPages = 1;

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
        recyclerViewSetUp();
       // testListViews();
        observeArticlesData("News");

        // swip to refersh
        binding.swipToRefreshLayout.setRefreshing(false);
        //binding.swipToRefreshLayout.setOnRefreshListener(this);
        binding.swipToRefreshLayout.setColorSchemeResources(R.color.purple_200,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

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
                    if(articleResponse.getResponse() != null){
                        for (int i=0; i<articleResponse.getResponse().getDocs().size(); i++){
                            Log.d(TAG, "observeArticlesData: "+articleResponse.getResponse().getDocs().get(i).getJsonMemberAbstract());
                            DocsItem docsItem = new DocsItem();
                            docsItem.setJsonMemberAbstract(articleResponse.getResponse().getDocs().get(i).getJsonMemberAbstract());
                            docsItem.setPubDate(articleResponse.getResponse().getDocs().get(i).getPubDate());
                            mMovieResponseArrayList.add(docsItem);
                        }
                        mCompanyProductionAdapter.notifyDataSetChanged();
                    }


                });

    }
    public void testListViews(){
        for (int i=0; i<100; i++){

            DocsItem docsItem = new DocsItem();
            docsItem.setJsonMemberAbstract("News from ");
            docsItem.setPubDate("2021-5-7");
            mMovieResponseArrayList.add(docsItem);
        }
        mCompanyProductionAdapter.notifyDataSetChanged();
    }
    private void recyclerViewSetUp() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding.loadListRecyclerView.setLayoutManager(layoutManager);
        binding.loadListRecyclerView.setHasFixedSize(true);
        mCompanyProductionAdapter = new SearchArticlesAdapter(view.getContext(), mMovieResponseArrayList);
        binding.loadListRecyclerView.setAdapter(mCompanyProductionAdapter);
        binding.loadListRecyclerView.invalidate();
    }

}
