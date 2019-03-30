package io.github.fentonmartin.aappz.recycler;

import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * RecyclerViewSnapHelper
 * <p>
 * SnapHelper is a helper class that helps in snapping any child view of the RecyclerView.
 * For example, you can snap the first visible item of the RecyclerView and make it always be
 * completely visible when scrolling comes to the idle position.
 * <p> How to use:
 * <p> RecyclerViewSnapHelper snapHelper = new RecyclerViewSnapHelper();
 * <p> snapHelper.attachToRecyclerView(recyclerView);
 */
@SuppressWarnings("unused")
public class RecyclerViewSnapHelper extends LinearSnapHelper {

    @Override
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider))
            return RecyclerView.NO_POSITION;

        final View currentView = findSnapView(layoutManager);
        if (currentView == null)
            return RecyclerView.NO_POSITION;

        final int currentPosition = layoutManager.getPosition(currentView);
        if (currentPosition == RecyclerView.NO_POSITION)
            return RecyclerView.NO_POSITION;

        return currentPosition;
    }
}