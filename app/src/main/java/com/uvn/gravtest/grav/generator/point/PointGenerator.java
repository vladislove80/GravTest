package com.uvn.gravtest.grav.generator.point;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;

import java.util.Vector;

public interface PointGenerator {
    Vector<PointF> generatePoints(int width, int height);
    void configure(AttributeSet attributeSet, Context context);
}
