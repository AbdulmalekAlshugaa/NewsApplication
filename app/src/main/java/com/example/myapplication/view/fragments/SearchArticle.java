package com.example.myapplication.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.R;
import com.example.myapplication.adapter.SearchArticlesAdapter;
import com.example.myapplication.databinding.SearchArticleBinding;
import com.example.myapplication.model.article.articles.DocsItem;
import com.example.myapplication.singleton.SearchSingleton;
import com.example.myapplication.viewModel.SearchArticleViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import io.reactivex.disposables.CompositeDisposable;

public class SearchArticle extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private View view;
    private SearchArticleBinding binding;
    // init article view model
    private SearchArticleViewModel searchArticleViewModel;
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
        searchArticleViewModel = new ViewModelProvider(this).get(SearchArticleViewModel.class);
        mCompositeDisposable = new CompositeDisposable();
        recyclerViewSetUp();
       // testListViews();

        binding.swipToRefreshLayout.setRefreshing(false);
        binding.swipToRefreshLayout.setOnRefreshListener(this);
        binding.swipToRefreshLayout.setColorSchemeResources(R.color.black,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        binding.searchButton.setOnClickListener(v -> {
         String searchText = Objects.requireNonNull(binding.articleSearchByEditText.getText()).toString();
            observeArticlesData(searchText);
            SearchSingleton.getInstance().setFilteringType(searchText);

        });
        return view;
    }



    private void observeArticlesData(String filteringType) {
        toggleLoading();
        HashMap<String, Object> searchingParams = new HashMap<>();
        searchingParams.put("q",filteringType);

        searchArticleViewModel.getAllTheArticles(mCompositeDisposable,currentPage,searchingParams)
                .observe(this, articleResponse -> {
                    if(articleResponse.getResponse() != null){
                        toggleLoading();
                        totalPages = articleResponse.getResponse().getMeta().getOffset();


                        for (int i=0; i<articleResponse.getResponse().getDocs().size(); i++){
                            Log.d(TAG, "observeArticlesData: "+articleResponse.getResponse().getDocs().get(i).getPubDate());
                            DocsItem docsItem = new DocsItem();
                            docsItem.setJsonMemberAbstract(articleResponse.getResponse().getDocs().get(i).getJsonMemberAbstract());
                            docsItem.setPubDate(articleResponse.getResponse().getDocs().get(i).getPubDate());
                            mMovieResponseArrayList.add(docsItem);
                        }
                        mCompanyProductionAdapter.notifyDataSetChanged();
                    }
                    binding.swipToRefreshLayout.setRefreshing(false);

                });

    }
    private void toggleLoading(){

        // check if the progressBar is currently running a
        if(binding.progressBar.isShown()){
            binding.progressBar.setVisibility(View.INVISIBLE);
        }else {
            binding.progressBar.setVisibility(View.VISIBLE);
        }

    }

    private void resetAllParamsToDefault() {
        currentPage = 1;
    }
    private void recyclerViewSetUp() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding.loadListRecyclerView.setLayoutManager(layoutManager);
        binding.loadListRecyclerView.setHasFixedSize(true);
        mCompanyProductionAdapter = new SearchArticlesAdapter(view.getContext(), mMovieResponseArrayList);
        binding.loadListRecyclerView.setAdapter(mCompanyProductionAdapter);
        binding.loadListRecyclerView.invalidate();

        binding.loadListRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(!binding.loadListRecyclerView.canScrollVertically(1)){
                    if(currentPage <= totalPages){
                        currentPage +=1;
                        observeArticlesData(SearchSingleton.getInstance().getFilteringType());
                    }else {
                        // here is the end of the list
                        Toast.makeText(getActivity(), "Here is the end of the list", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });
    }

    @Override
    public void onRefresh() {
        mMovieResponseArrayList.clear();
        resetAllParamsToDefault();
        observeArticlesData("elections");
    }

    @Override
    public void onStop() {
        super.onStop();
        mCompositeDisposable.clear();

    }
}
