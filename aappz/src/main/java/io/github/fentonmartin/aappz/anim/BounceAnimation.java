package io.github.fentonmartin.aappz.anim;

public class BounceAnimation implements android.view.animation.Interpolator {

    private final double mAmplitude;
    private final double mFrequency;

    public BounceAnimation(double amplitude, double frequency) {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }

    public float getInterpolation(float time) {
        return (float) (-1 * Math.pow(Math.E, -time / mAmplitude) *
                Math.cos(mFrequency * time) + 1);
    }
}
