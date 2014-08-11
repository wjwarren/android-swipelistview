package com.fortysevendeg.swipelistview.refresh;

/**
 * @author Wijnand
 * @author keiththompson
 */
public interface RefreshSwipeListener {

    /**
     * Updates the scrolling state.
     * @param canScroll boolean - Whether or not scrolling is possible.
     */
    void setScroll(boolean canScroll);
}
