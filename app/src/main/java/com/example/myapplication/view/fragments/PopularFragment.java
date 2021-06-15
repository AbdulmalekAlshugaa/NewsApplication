package com.example.myapplication.view.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.R;
import com.example.myapplication.adapter.MostViewAdapter;
import com.example.myapplication.databinding.LoadingFragmentBinding;
import com.example.myapplication.model.article.mostView.ResultsItem;
import com.example.myapplication.singleton.SortBySingleton;
import com.example.myapplication.viewModel.PopularViewModel;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

public class PopularFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private View view;
    private LoadingFragmentBinding binding;
    private static final String TAG = "LoadDataFragment";
    private PopularViewModel popularViewModel;
    private CompositeDisposable mCompositeDisposable;
    private final ArrayList<ResultsItem> mPopularArrayList = new ArrayList<>();

    private MostViewAdapter mPopularAdapter; // Adapt

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding  = LoadingFragmentBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        view = binding.getRoot();
        // init compositDisposable


        recyclerViewSetUp();

        popularViewModel = new ViewModelProvider(this).get(PopularViewModel.class);
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
        binding.popularSearchByEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                handlePopularSearchByTitle(s.toString());

            }
        });


        return view;
    }
    private void recyclerViewSetUp() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding.mostViewListRecyclerView.setLayoutManager(layoutManager);
        binding.mostViewListRecyclerView.setHasFixedSize(true);
        mPopularAdapter = new MostViewAdapter(view.getContext(), mPopularArrayList);
        binding.mostViewListRecyclerView.setAdapter(mPopularAdapter);
        binding.mostViewListRecyclerView.invalidate();

    }

    private void observeMostViewArticles(Integer period,String whichEndPoint) {
        popularViewModel.getAllMostViewArticles(mCompositeDisposable,period,whichEndPoint)

                .observe(this, articleResponse -> {
                    if(articleResponse.getResults().size() > 0){
                        for (int i=0; i<articleResponse.getResults().size(); i++){
                            ResultsItem item = new ResultsItem();
                            item.setTitle(articleResponse.getResults().get(i).getTitle());
                            item.setPublishedDate(articleResponse.getResults().get(i).getPublishedDate());
                            mPopularArrayList.add(item);
                        }
                        mPopularAdapter.notifyDataSetChanged();
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
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }
    private void handlePopularSearchByTitle(String text) {
        ArrayList<ResultsItem> filteredList = new ArrayList<>();
        for (ResultsItem item : mPopularArrayList) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mPopularAdapter.filterList(filteredList);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.oneDay:
                mPopularArrayList.clear();
                observeMostViewArticles(1, SortBySingleton.getInstance().getSortBy());
                return true;

            case R.id.sevenDays:
                mPopularArrayList.clear();
                observeMostViewArticles(7, SortBySingleton.getInstance().getSortBy());

                return true;
            case R.id.oneMonth:
                mPopularArrayList.clear();
                observeMostViewArticles(30, SortBySingleton.getInstance().getSortBy());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
