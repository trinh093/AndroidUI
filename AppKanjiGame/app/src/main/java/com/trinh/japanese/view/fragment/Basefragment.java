package com.trinh.japanese.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trinh.japanese.entities.OnFragmentCallback;

public abstract class Basefragment extends Fragment implements View.OnClickListener {
    public static final String TAG = Basefragment.class.getName();
    protected Context mContext;
    protected View mRootView;
    protected OnFragmentCallback callBack;
    protected  Object mData;
    protected  String sourceTag;

    public void setSourceTag(String sourceTag) {
        this.sourceTag = sourceTag;
    }

    protected void notify(String msg) {
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }

    public final void setData(Object mData) {
        this.mData = mData;
    }

    public void setCallBack(OnFragmentCallback callBack) {
        this.callBack = callBack;
    }

    @Override
    public final void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater,
                                   @Nullable ViewGroup container,
                                   @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        initView();
        return mRootView;
    }

    public final <T extends View> T findViewById(int id) {
        return mRootView.findViewById(id);
    }

    protected final <T extends View> T findViewById(int id, View.OnClickListener event) {
        T view = findViewById(id);
        if (view != null && event != null) {
            view.setOnClickListener(event);
        }
        return view;
    }

    protected abstract void initView();
    protected abstract int getLayoutId();
    @Override
    public void onClick(View view) {
        //do nothing
    }

    public void backToPrevious() {
        //do nothing
    }
}
