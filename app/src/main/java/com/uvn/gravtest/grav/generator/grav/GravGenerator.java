package com.uvn.gravtest.grav.generator.grav;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;

import com.uvn.gravtest.grav.figure.Grav;

public interface GravGenerator {
    Grav generate(PointF startPoint, Paint paint);

    void configure(AttributeSet attributeSet, Context context);
}
