package com.uvn.gravtest.grav.generator;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.uvn.gravtest.grav.generator.anim.GravAnimatorGenerator;
import com.uvn.gravtest.grav.generator.grav.BallGenerator;
import com.uvn.gravtest.grav.generator.grav.GravGenerator;
import com.uvn.gravtest.grav.generator.paint.PaintGenerator;
import com.uvn.gravtest.grav.generator.paint.RandomColorGenerator;
import com.uvn.gravtest.grav.generator.point.PointGenerator;
import com.uvn.gravtest.grav.generator.point.RegularPointGenerator;
import com.uvn.gravtest.grav.util.ClassUtil;

/**
 * Created by Vladyslav Ulianytskyi on 18.03.2019.
 */
public class GeneratorFactory {
    private Context context;

    public GeneratorFactory(Context context) {
        this.context = context;
    }

    public PaintGenerator createPaint(String className, AttributeSet attrs) {
        if (className == null || className.isEmpty()) {
            return new RandomColorGenerator();
        }
        PaintGenerator paintGenerator = ClassUtil.getClassByName(className, PaintGenerator.class);
        paintGenerator.configure(attrs, context);
        return paintGenerator;
    }

    public PointGenerator createPoint(String className, AttributeSet attributeSet) {
        if (className == null || className.isEmpty()) {
            return new RegularPointGenerator();
        }
        PointGenerator generator = ClassUtil.getClassByName(className, PointGenerator.class);
        generator.configure(attributeSet, context);
        return generator;
    }

    public GravGenerator createGrav(String className, AttributeSet attrs) {
        if (className == null || className.isEmpty()) {
            return new BallGenerator();
        }
        GravGenerator generator = ClassUtil.getClassByName(className, GravGenerator.class);
        generator.configure(attrs, context);
        return generator;
    }

    @Nullable
    public GravAnimatorGenerator createAnimator(String className, AttributeSet attributeSet) {
        if (className == null || className.isEmpty()) {
            return null;
        }

        GravAnimatorGenerator generator = ClassUtil.getClassByName(className, GravAnimatorGenerator.class);
        generator.configure(attributeSet, context);
        return generator;
    }
}
