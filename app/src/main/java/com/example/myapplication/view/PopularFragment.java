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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.adapter.MostViewAdapter;
import com.example.myapplication.databinding.LoadingFragmentBinding;
import com.example.myapplication.model.article.mostView.ResultsItem;
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

    private MostViewAdapter mCompanyProductionAdapter; // Adapt

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


        return view;
    }
    private void recyclerViewSetUp() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding.mostViewListRecyclerView.setLayoutManager(layoutManager);
        binding.mostViewListRecyclerView.setHasFixedSize(true);
        mCompanyProductionAdapter = new MostViewAdapter(view.getContext(), mPopularArrayList);
        binding.mostViewListRecyclerView.setAdapter(mCompanyProductionAdapter);
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
