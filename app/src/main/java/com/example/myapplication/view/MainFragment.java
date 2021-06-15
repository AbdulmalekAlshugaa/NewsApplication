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
        return view;
    }
}
