/*******************************************************************************

  * Copyright (c) 2005 - 2013 Nos Doughty
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *     http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.

 ******************************************************************************/
package org.llaith.toolkit.common.util.reflection;

import java.lang.Class;
import java.lang.Object;
import java.lang.Throwable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by IntelliJ IDEA.
 * User: nos
 * Date: 15-Dec-2009
 * Time: 06:26:42
 * <p/>
 * Modified from:
 * http://www.ibm.com/developerworks/java/library/j-jtp08305.html
 */
public class ProxyUtil {

    public static <T> T proxyOf(final Class<T> iface, final T obj) {
        return iface.cast(
                Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                        new Class<?>[]{iface},
                        new InvocationHandler() {
                            public Object invoke(final Object proxy, final Method method,
                                                 final Object[] args) throws Throwable {
                                return method.invoke(obj,args);
                            }
                        }));
    }
}
