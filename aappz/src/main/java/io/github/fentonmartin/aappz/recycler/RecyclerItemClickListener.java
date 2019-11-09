package io.github.fentonmartin.aappz.recycler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * RecyclerItemClickListener
 * <p>
 * An OnItemTouchListener allows the application to intercept touch events in progress
 * at the view hierarchy level of the RecyclerView before those touch events are considered
 * for RecyclerView's own scrolling behavior.
 * <p> How to use:
 * <p> recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(...));
 * <p> This function should only be called once in onCreate()
 *
 */
@SuppressWarnings("unused")
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public interface OnSimpleClickListener {
        void onItemClick(View view, int position);
    }

    private final GestureDetector mGestureDetector;

    private OnItemClickListener mListener;

    private OnSimpleClickListener mSimpleListener;

    private final boolean isTouch;

    /**
     * Implement RecyclerItemClickListener on RecyclerView without onItemLongClick
     *
     * @param context        the application context
     * @param recyclerView   the targeted recycler view
     * @param isTouchEnabled the touch is enabled
     * @param listener       the simple click listener
     */
    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, boolean isTouchEnabled, OnSimpleClickListener listener) {
        mSimpleListener = listener;
        isTouch = isTouchEnabled;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
            }
        });
    }

    /**
     * Implement RecyclerItemClickListener on RecyclerView without onItemLongClick
     *
     * @param context        the application context
     * @param recyclerView   the targeted recycler view
     * @param listener       the simple click listener
     */
    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnSimpleClickListener listener) {
        mSimpleListener = listener;
        isTouch = true;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
            }
        });
    }

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

    /**
     * Implement RecyclerItemClickListener on RecyclerView
     *
     * @param context      the application context
     * @param recyclerView the targeted recycler view
     * @param listener     the item click listener
     */
    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
        mListener = listener;
        isTouch = true;
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
        if (childView != null && mSimpleListener != null && mGestureDetector.onTouchEvent(e))
            mSimpleListener.onItemClick(childView, view.getChildAdapterPosition(childView));
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