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
package org.llaith.toolkit.core.dto;

import org.junit.Test;
import org.llaith.toolkit.core.dto.instances.ContactDto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assume.assumeThat;


/**
 * Test the basic change behaviour and builder transitions.
 */
public class DtoChangesTest {

    @Test
    public void acceptingChangedInstancesDoesNothingWeird() throws Exception {
        assertThat(
                newContact().setEmail("newemail@address.com").acceptChanges().getEmail(),
                is(equalTo("newemail@address.com")));
    }

    @Test
    public void cancellingAcceptedChangesDoesNothing() throws Exception {
        assertThat(
                newContact().setEmail("newemail@address.com").acceptChanges().cancelChanges().getEmail(),
                is(equalTo("newemail@address.com")));
    }

    @Test
    public void cancellingRollsBackToLastAcceptedChanges() throws Exception {
        assertThat(
                newContact()
                        .setEmail("newemail@address.com")
                        .acceptChanges()
                        .setEmail("neweremail@address.com")
                        .cancelChanges()
                        .getEmail(),
                is(equalTo("newemail@address.com")));
    }

    @Test
    public void theFirstAcceptFlagsTheObjectAsNotNew() throws Exception {
        assumeThat(
                newContact().isNew(),
                is(true));

        assertThat(
                newContact().acceptChanges().isNew(),
                is(false));
    }

    @Test
    public void aCancelOnNewInstanceIsOkButClearsIt() throws Exception {
        final ContactDto target = ContactDto.unsavedInstance();

        assumeThat(
                target.isNew(),
                is(true));

        assertThat(
                target.setName("name").getName(),
                is(equalTo("name")));

        assumeThat(
                target.cancelChanges().isNew(),
                is(true));

        assertThat(
                target.getName(),
                is(nullValue()));
    }

    private ContactDto newContact() throws Exception {
        return ContactDto.unsavedInstance("NOS01","Name","email@address.com","555-1234",true,40l,null,null);
    }

}
