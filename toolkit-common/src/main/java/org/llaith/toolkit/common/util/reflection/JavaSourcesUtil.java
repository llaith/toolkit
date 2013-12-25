package org.llaith.toolkit.common.util.reflection;

import javax.annotation.Nonnull;
import java.io.File;

/**
 *
 */
public class JavaSourcesUtil {

    public static String packageToDirPath(@Nonnull Class<?> c) {
        return c.getPackage().getName().replace(".",File.separator);
    }

    public static String classToFilePath(@Nonnull Class<?> c) {
        if (c.getDeclaringClass() != null) throw new IllegalArgumentException("Cannot process nested classes: "+c.getName());
        return c.getName().replace(".",File.separator)+".java";
    }

    public static String sourceLocation(@Nonnull final Class<?> c) {
        return c.getProtectionDomain().getCodeSource().getLocation().getPath();
    }

}
