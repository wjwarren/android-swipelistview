package com.fortysevendeg.swipelistview.refresh;

import android.content.Context;
import android.util.AttributeSet;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.fortysevendeg.swipelistview.SwipeListViewTouchListener;

/**
 * Specialized {@link SwipeListView} that provides horizontal AND vertical swipe functionality.<br/>
 * Inspired by <a href="https://github.com/keiththompson/SwipeListViewRefresh">SwipeListViewRefresh</a>.
 *
 * @author Wijnand
 * @author keiththompson
 */
public class RefreshSwipeListView extends SwipeListView {

    /**
     * @see SwipeListView#SwipeListView
     * @param context See {@link SwipeListView#SwipeListView}.
     * @param swipeBackView See {@link SwipeListView#SwipeListView}.
     * @param swipeFrontView See {@link SwipeListView#SwipeListView}.
     */
    public RefreshSwipeListView(Context context, int swipeBackView, int swipeFrontView) {
        super(context, swipeBackView, swipeFrontView);
    }

    /**
     * @see SwipeListView#SwipeListView
     * @param context See {@link SwipeListView#SwipeListView}.
     * @param attrs See {@link SwipeListView#SwipeListView}.
     */
    public RefreshSwipeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @see SwipeListView#SwipeListView
     * @param context See {@link SwipeListView#SwipeListView}.
     * @param attrs See {@link SwipeListView#SwipeListView}.
     * @param defStyle See {@link SwipeListView#SwipeListView}.
     */
    public RefreshSwipeListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /** {@inheritDoc} */
    @Override
    protected SwipeListViewTouchListener createTouchListener(SwipeListView listView, int frontView, int backView) {
        return new SwipeRefreshListViewTouchListener(listView, frontView, backView);
    }

    /**
     * Stores a new {@link RefreshSwipeListener}.
     * @param listener {@link RefreshSwipeListener} - The listener to store.
     */
    public void setRefreshSwipeListener(RefreshSwipeListener listener) {
        ((SwipeRefreshListViewTouchListener) getTouchListener()).setRefreshSwipeListener(listener);
    }
}
