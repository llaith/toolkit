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
package org.llaith.toolkit.core.stage.impl;

import org.llaith.toolkit.core.status.StatusToken;

/**
* Intended to be used to implement things like transaction control. Stage is passed in case
 * the one listener is tracking multiple stages.
*/
public interface StageListener {

    void onStart(Object source, StatusToken status);

    void onComplete(Object source, StatusToken status);

    // deliberately do not pass exception! Use exceptionHandler elsewhere if
    // needed. This is purly a notification of failure and need to 'rollback'.
    void onFailure(Object source, StatusToken status);

}
