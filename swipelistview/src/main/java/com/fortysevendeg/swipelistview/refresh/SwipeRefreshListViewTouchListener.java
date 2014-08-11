package com.fortysevendeg.swipelistview.refresh;

import android.widget.AbsListView;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.fortysevendeg.swipelistview.SwipeListViewTouchListener;

/**
 * Touch listener implementation for the SwipeListView.<br/>
 * Inspired by <a href="https://github.com/keiththompson/SwipeListViewRefresh">SwipeListViewRefresh</a>.
 *
 * @author Wijnand
 * @author keiththompson
 */
public class SwipeRefreshListViewTouchListener extends SwipeListViewTouchListener {

    private RefreshSwipeListener mRefreshSwipeListener;

    /**
     * Constructor.
     *
     * @param swipeListView {@link RefreshSwipeListView} - SwipeListView.
     * @param swipeFrontView int - Front view resource identifier.
     * @param swipeBackView int Back view resource identifier.
     */
    public SwipeRefreshListViewTouchListener(SwipeListView swipeListView, int swipeFrontView, int swipeBackView) {
        super(swipeListView, swipeFrontView, swipeBackView);
    }

    /** {@inheritDoc} */
    @Override
    public AbsListView.OnScrollListener makeScrollListener() {
        return new AbsListView.OnScrollListener() {

            /** {@inheritDoc} */
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                if (!getSwipeListView().canListViewScrollUp() && !isSwiping()) {
                    if (mRefreshSwipeListener != null) {
                        mRefreshSwipeListener.setScroll(false);
                    }
                } else {
                    if (mRefreshSwipeListener != null) {
                        mRefreshSwipeListener.setScroll(true);
                    }
                }

                scrollStateChangeHandler(absListView, scrollState);
            }

            /** {@inheritDoc} */
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                scrollHandler(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
        };
    }

    /**
     * Stores a new {@link RefreshSwipeListener}.
     * @param listener {@link RefreshSwipeListener} - The listener to store.
     */
    public void setRefreshSwipeListener(RefreshSwipeListener listener) {
        mRefreshSwipeListener = listener;
    }
}
