package com.example.myapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.MainFragmentBinding;
import com.example.myapplication.singleton.SortBySingleton;
import com.example.myapplication.view.fragments.PopularFragment;
import com.example.myapplication.view.fragments.SearchArticle;

import java.util.Objects;



public class MainFragment extends Fragment {

    private View view;
    private MainFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       binding  = MainFragmentBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        view = binding.getRoot();
        // init compositDisposable

        binding.searchArticlesFragment.setOnClickListener(v -> {
            SearchArticle nextFrag= new SearchArticle();
            Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_FrameLayout_Activity, nextFrag, "search")
                    .addToBackStack(null)
                    .commit();
        });
        binding.mostViewFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key","MostView");
                PopularFragment nextFrag= new PopularFragment();
                nextFrag.setArguments(bundle);
                SortBySingleton.getInstance().setSortBy("viewed");
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_FrameLayout_Activity, nextFrag, "MostView")
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.mostShared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key","MostShared");
                PopularFragment nextFrag= new PopularFragment();
                nextFrag.setArguments(bundle);
                SortBySingleton.getInstance().setSortBy("shared");
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_FrameLayout_Activity, nextFrag, "mostShared")
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.mostEmailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key","MostEmailed");
                PopularFragment nextFrag= new PopularFragment();
                nextFrag.setArguments(bundle);
                SortBySingleton.getInstance().setSortBy("emailed");
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_FrameLayout_Activity, nextFrag, "mostEmailed")
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}
