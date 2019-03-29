package io.github.fentonmartin.aappz.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * RecyclerItemClickListener
 * <p>
 * An OnItemTouchListener allows the application to intercept touch events in progress
 * at the view hierarchy level of the RecyclerView before those touch events are considered
 * for RecyclerView's own scrolling behavior.
 * <p>
 * <p> How to use:
 * <p> recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(...));
 */
@SuppressWarnings("unused")
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private GestureDetector mGestureDetector;

    private OnItemClickListener mListener;

    private boolean isTouch;

    /**
     * Implement RecyclerItemClickListener on RecyclerView
     *
     * @param context        the application context
     * @param recyclerView   the targeted recycler view
     * @param isTouchEnabled the touch is enabled
     * @param listener       the item click listener
     */
    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, boolean isTouchEnabled, OnItemClickListener listener) {
        mListener = listener;
        isTouch = isTouchEnabled;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && mListener != null)
                    mListener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView));
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView view, @NonNull MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e))
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
        /* return false for enable touch */
        return !isTouch;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView view, @NonNull MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}