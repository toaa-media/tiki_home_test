package com.vn.tikihometest.models;

import com.vn.tikihometest.interfaces.IKeyword;
import com.vn.tikihometest.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * The HotKeyword model.
 */
public class HotKeyword implements IKeyword {

    private String originalName;
    private String displayName;
    private int keywordColor;

    public HotKeyword(String originalName) {
        this.originalName = originalName;
        this.keywordColor = CommonUtils.getRandomColor();
    }

    @Override
    public String getOriginalName() {
        return originalName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public int getKeywordColor() {
        return keywordColor;
    }

    /**
     * Converts the list of keyword names in {@link String} to the list of {@link IKeyword} objects.
     *
     * @param keywordNames the list of keyword names.
     * @return the list of {@link IKeyword} objects.
     */
    public static Observable<List<IKeyword>> convertNamesToKeywords(List<String> keywordNames) {
        if (CommonUtils.isEmpty(keywordNames)) {
            List<IKeyword> result = new ArrayList<>();
            return Observable.just(result);
        }
        return Observable.just(keywordNames)
                .flatMap(Observable::fromIterable)
                .map((Function<String, IKeyword>) HotKeyword::new)
                .toList().toObservable();
    }
}
