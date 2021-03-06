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
package org.llaith.toolkit.core.status.impl;

import org.llaith.toolkit.core.memo.Memo;
import org.llaith.toolkit.core.status.StatusLevel;

/**
 * Used to have an ident in the methods, but this should now be placed into the ctor of a concrete
 * copy of this interface.
 *
 * The level is passed through for the exception in case the impl does not support message correlation (updating).
 */
public interface StatusLogger {

    void reportStart(ElapsedContext snapshot, String message);

    void reportSuccess(ElapsedContext snapshot, String message);

    void reportFailure(ElapsedContext snapshot, String message);

    void reportMessage(ElapsedContext snapshot, Object id, StatusLevel level, Memo memo);

    void reportException(ElapsedContext snapshot, Object id, StatusLevel level, Exception e);

    void reportProgress(ElapsedContext snapshot, Object id, StatusLevel level, String heading, int total, int count, String message);

}
