package com.vn.tikihometest.vms;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vn.tikihometest.BR;
import com.vn.tikihometest.R;
import com.vn.tikihometest.adapters.KeywordAdapter;
import com.vn.tikihometest.apis.ApiManager;
import com.vn.tikihometest.interfaces.IKeyword;
import com.vn.tikihometest.models.HotKeyword;
import com.vn.tikihometest.utils.CommonUtils;
import com.vn.tikihometest.vms.base.BaseVM;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by namhoainguyen on 11/6/18.
 */
public class MainVM extends BaseVM {

    private KeywordAdapter keywordAdapter;

    public MainVM(Context context) {
        super(context);
        keywordAdapter = new KeywordAdapter(new ArrayList<>());
    }

    @Override
    public void onCreate() {
        callApiToGetKeywords();
    }

    private void callApiToGetKeywords() {
        Disposable disposable = ApiManager.apis().getKeywordNames()
                .flatMap((Function<List<String>, Observable<List<IKeyword>>>) HotKeyword::convertNamesToKeywords)
                .compose(CommonUtils.getObservableTransformer())
                .subscribe(iKeywords -> keywordAdapter.setItems(iKeywords));
        compositeDisposable.add(disposable);
    }

    public KeywordAdapter getKeywordAdapter() {
        return keywordAdapter;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    public int getVariableId() {
        return BR.vm;
    }
}
