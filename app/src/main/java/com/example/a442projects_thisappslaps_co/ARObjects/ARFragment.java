package com.example.a442projects_thisappslaps_co.ARObjects;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a442projects_thisappslaps_co.R;

import java.util.ArrayList;

public class ARFragment extends Fragment implements View.OnClickListener {

    private RecyclerView mARObjectsRecyclerView;
    private ImageButton mBackButton;

    public ARFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.ar_fragment, container, false);

        initializeViewVariable(view);
        mBackButton.setOnClickListener(this);
        setARObjectsAdapter();

        return view;
    }

    private void initializeViewVariable(View view) {
        mBackButton = view.findViewById(R.id.back_image_btn);
        mARObjectsRecyclerView = view.findViewById(R.id.ar_objects_recycler_view);
    }

    private void setARObjectsAdapter() {
        mARObjectsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mARObjectsRecyclerView.setAdapter(
                new ARObjectsAdapter(new ARObjectsController().createARObjectsDummyList()));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_image_btn) {
            assert getFragmentManager() != null;
            getFragmentManager().popBackStackImmediate();
        }
    }

    private class ARObjectsHolder extends RecyclerView.ViewHolder {

        ARObjectsHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.ar_object_item, viewGroup, false));
        }

        void bind(Integer drawableRes) {
            itemView.setBackgroundResource(drawableRes);
        }
    }

    private class ARObjectsAdapter extends RecyclerView.Adapter<ARObjectsHolder> {

        private ArrayList<Integer> mARObjectDrawableResList;

        ARObjectsAdapter(ArrayList<Integer> arObjectDrawableResList) {
            mARObjectDrawableResList = arObjectDrawableResList;
        }

        @NonNull
        @Override
        public ARObjectsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ARObjectsHolder(LayoutInflater.from(getContext()), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ARObjectsHolder holder, int position) {
            holder.bind(mARObjectDrawableResList.get(position));
        }

        @Override
        public int getItemCount() {
            return mARObjectDrawableResList.size();
        }
    }
}
