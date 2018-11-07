package com.vn.tikihometest.views;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.vn.tikihometest.interfaces.IKeyword;
import com.vn.tikihometest.utils.CommonUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by namhoainguyen on 11/6/18.
 */
public class KeywordTextView extends android.support.v7.widget.AppCompatTextView {

    private Disposable processKeywordDisposable;

    public KeywordTextView(Context context) {
        super(context);
    }

    public KeywordTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public KeywordTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (processKeywordDisposable != null) processKeywordDisposable.dispose();
    }

    /**
     * Sets keyword object to the {@link android.widget.TextView}
     *
     * @param keyword the keyword object.
     */
    public void setKeyword(final IKeyword keyword) {
        if (TextUtils.isEmpty(keyword.getOriginalName())) {
            setText("");
            return;
        }
        if (!TextUtils.isEmpty(keyword.getDisplayName())) {
            setText(keyword.getDisplayName());
            return;
        }
        if (processKeywordDisposable != null) processKeywordDisposable.dispose();
        processKeywordDisposable = processKeyword(keyword).compose(CommonUtils.getObservableTransformer()).subscribe(finalKeyword -> {
            keyword.setDisplayName(finalKeyword);
            setText(finalKeyword);
        });
    }

    /**
     * Processes the keyword object to generate the final name satisfied the conditions are:
     * - If the name is more than one word, then display in two lines.
     * - The difference in width of each line is minimal.
     *
     * @param keyword the keyword instance.
     * @return the final name.
     */
    private Observable<String> processKeyword(IKeyword keyword) {
        String[] wordArr = keyword.getOriginalName().split(" ");
        if (wordArr.length == 1) {
            return Observable.just(wordArr[0]);
        } else {
            float diffWidth = Integer.MAX_VALUE;
            int newLineIndex = 0;
            for (int i = 0; i < wordArr.length; i++) {
                float newDiffWidth = diffWidth(makeLineToIndex(i, wordArr), makeLineFromIndex(i, wordArr));
                if (newDiffWidth > diffWidth) break;
                else {
                    diffWidth = newDiffWidth;
                    newLineIndex = i;
                }
            }
            String finalKeyword = makeLineToIndex(newLineIndex, wordArr) + "\n" + makeLineFromIndex(newLineIndex, wordArr);
            return Observable.just(finalKeyword);
        }
    }

    /**
     * Make a line from 0 to the given index in string array.
     *
     * @param index   the index.
     * @param wordArr the word array.
     * @return the line.
     */
    private String makeLineToIndex(int index, String[] wordArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            stringBuilder.append(wordArr[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     * Make a line from the given index to the end in string array.
     *
     * @param index   the index.
     * @param wordArr the word array.
     * @return the line.
     */
    private String makeLineFromIndex(int index, String[] wordArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index + 1; i < wordArr.length; i++) {
            stringBuilder.append(wordArr[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     * Gets the difference in width of two lines.
     *
     * @param line1 the line one.
     * @param line2 the line two.
     * @return the difference in width.
     */
    private float diffWidth(String line1, String line2) {
        int line1Width = getTextWidth(line1);
        int line2Width = getTextWidth(line2);
        return Math.abs(line1Width - line2Width);
    }

    /**
     * Gets the width of text.
     *
     * @param text the text.
     * @return the width of text.
     */
    private int getTextWidth(String text) {
        if (TextUtils.isEmpty(text)) return 0;
        Rect bounds = new Rect();
        getPaint().getTextBounds(text, 0, text.length(), bounds);
        return bounds.width();
    }

    @BindingAdapter("keyword")
    public static void setKeyword(KeywordTextView textView, IKeyword keyword) {
        textView.setKeyword(keyword);
    }
}
