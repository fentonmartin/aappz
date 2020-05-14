package io.github.fentonmartin.aappz.recycler;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerItemClickListener
 * <p>
 * An OnItemTouchListener allows the application to intercept touch events in progress
 * at the view hierarchy level of the RecyclerView before those touch events are considered
 * for RecyclerView's own scrolling behavior.
 * <p> How to use:
 * <p> recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(...));
 * <p> This function should only be called once in onCreate()
 * <p>
 * <p> Accessing Particular View Component in the RecyclerView Item
 * <p> In order to access particular view component inside RecyclerView, for example, In order to perform some operation only on clicking the profile image in the RecyclerView row item, then here is the small hack for you.
 * <p> We can define the component by findViewById via it’s respective View. Here is the code for you. ImageView picture = (ImageView) view.findViewById(R.id.picture); picture.setOnClickListener(new View.OnClickListener() {...});
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
     * @param context      the application context
     * @param recyclerView the targeted recycler view
     * @param listener     the simple click listener
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