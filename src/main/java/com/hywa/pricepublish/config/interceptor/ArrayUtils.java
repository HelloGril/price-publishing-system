package com.hywa.pricepublish.config.interceptor;

import com.hywa.pricepublish.common.enums.Module;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils {
    public static boolean contains(Module[] modules, Module all) {
        List<Module> list = Arrays.asList(modules);
        return list.contains(all);
    }
}
