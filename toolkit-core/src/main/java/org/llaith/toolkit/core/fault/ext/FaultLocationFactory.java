package org.llaith.toolkit.core.fault.ext;

import org.llaith.toolkit.core.fault.FaultLocation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 */
public class FaultLocationFactory {

    public static FaultLocation forFileLocation(final String filename) {
        return new FaultLocation(Arrays.asList(filename));
    }

    public static FaultLocation forFileLocation(final String filename, final int linenumber) {
        return new FaultLocation(Arrays.asList(filename,":"+linenumber));
    }

    public static FaultLocation forClass(final Class<?> type) {
        return forClass(type.getName());
    }

    public static FaultLocation forClass(final String className) {
        return new FaultLocation(Arrays.asList(className));
    }

    public static FaultLocation forField(final Field field) {
        return forField(field.getDeclaringClass().getName(),field.getName());
    }

    public static FaultLocation forField(final String className, final String fieldName) {
        return new FaultLocation(Arrays.asList(className,fieldName));
    }

    public static FaultLocation forMethod(final Method method) {
        return new FaultLocation(Arrays.asList(method.getDeclaringClass().getName(),method.getName()));
    }

    public static FaultLocation forMethod(final String className, final String methodName) {
        return new FaultLocation(Arrays.asList(className,methodName+"()"));
    }

}