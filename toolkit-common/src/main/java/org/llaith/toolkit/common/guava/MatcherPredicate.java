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
package org.llaith.toolkit.common.guava;

import com.google.common.base.Predicate;
import org.hamcrest.Matcher;

/**
 *
 */
public class MatcherPredicate<T> implements Predicate<T> {

    public static <X> MatcherPredicate<X> match(final Matcher<X> matcher) {
        return new MatcherPredicate<>(matcher);
    }

    private final Matcher<T> matcher;

    public MatcherPredicate(final Matcher<T> matcher) {
        this.matcher = matcher;
    }

    public boolean apply(final T input) {
        return matcher.matches(input);
    }
}
