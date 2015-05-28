package com.magicyu.toolbox.ann;

import android.view.View;

import java.lang.annotation.*;

/**
 * Created by yushiwei on 15-5-28.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@Inherited
public @interface Adapter {
    int[] value() default {View.NO_ID};
}
