package com.example.myapplication.view;

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
import com.example.myapplication.adapter.MostViewAdapter;
import com.example.myapplication.adapter.SearchArticlesAdapter;
import com.example.myapplication.databinding.LoadingFragmentBinding;
import com.example.myapplication.databinding.MainFragmentBinding;
import com.example.myapplication.model.article.articles.DocsItem;
import com.example.myapplication.model.article.mostView.ResultsItem;
import com.example.myapplication.singleton.SearchSingleton;
import com.example.myapplication.viewModel.ArticleListViewModel;
import com.example.myapplication.viewModel.MostViewViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import io.reactivex.disposables.CompositeDisposable;

public class LoadDataFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private View view;
    private LoadingFragmentBinding binding;
    private static final String TAG = "LoadDataFragment";
    private MostViewViewModel articleListViewModel;
    private CompositeDisposable mCompositeDisposable;
    private final ArrayList<ResultsItem> mMovieResponseArrayList = new ArrayList<>();

    private MostViewAdapter mCompanyProductionAdapter; // Adapt

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding  = LoadingFragmentBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        view = binding.getRoot();
        // init compositDisposable

        recyclerViewSetUp();

        articleListViewModel = new ViewModelProvider(this).get(MostViewViewModel.class);
        mCompositeDisposable = new CompositeDisposable();

        Bundle bundle = this.getArguments();
        if(bundle != null){
            // handle your code here.
            Log.d(TAG, "onCreateView: "+bundle.getString("key"));

            switch (bundle.getString("key")){
                case "MostShared":
                    observeMostViewArticles(7,"shared");
                    break;
                case "MostView":
                    observeMostViewArticles(30,"viewed");
                    break;
                case "MostEmailed":
                    observeMostViewArticles(1,"emailed");
                    break;
                default:
                    Toast.makeText(view.getContext(),"Something went wrong", Toast.LENGTH_LONG).show();
            }


        }


        return view;
    }
    private void recyclerViewSetUp() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding.mostViewListRecyclerView.setLayoutManager(layoutManager);
        binding.mostViewListRecyclerView.setHasFixedSize(true);
        mCompanyProductionAdapter = new MostViewAdapter(view.getContext(), mMovieResponseArrayList);
        binding.mostViewListRecyclerView.setAdapter(mCompanyProductionAdapter);
        binding.mostViewListRecyclerView.invalidate();

    }

    private void observeMostViewArticles(Integer period,String whichEndPoint) {
        articleListViewModel.getAllMostViewArticles(mCompositeDisposable,period,whichEndPoint)

                .observe(this, articleResponse -> {
                    if(articleResponse.getResults().size() > 0){
                        for (int i=0; i<articleResponse.getResults().size(); i++){
                            ResultsItem item = new ResultsItem();
                            item.setTitle(articleResponse.getResults().get(i).getTitle());
                            item.setPublishedDate(articleResponse.getResults().get(i).getPublishedDate());
                            mMovieResponseArrayList.add(item);
                        }
                        mCompanyProductionAdapter.notifyDataSetChanged();
                    }
                    binding.swipToRefreshLayout.setRefreshing(false);

                });
        binding.progressBar.setVisibility(View.INVISIBLE);

    }
    @Override
    public void onRefresh() {

    }

    @Override
    public void onStop() {
        super.onStop();
        mCompositeDisposable.clear();

    }
}
