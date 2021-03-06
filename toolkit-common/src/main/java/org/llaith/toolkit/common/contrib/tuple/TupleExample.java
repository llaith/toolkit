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
package org.llaith.toolkit.common.contrib.tuple;


import org.llaith.toolkit.common.contrib.tuple.TupleType.DefaultFactory;

public class TupleExample {

    public static void main(final String[] args) {

        // This code probably should be part of a suite of unit tests
        // instead of part of this a sample program

        final TupleType tripletTupleType = DefaultFactory.create(
                Number.class,
                String.class,
                Character.class);

        final Tuple t1 = tripletTupleType.createTuple(1,"one",'a');
        final Tuple t2 = tripletTupleType.createTuple(2l,"two",'b');
        final Tuple t3 = tripletTupleType.createTuple(3f,"three",'c');
        final Tuple tnull = tripletTupleType.createTuple(null,"(null)",null);
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        System.out.println("t3 = " + t3);
        System.out.println("tnull = " + tnull);

        final TupleType emptyTupleType = DefaultFactory.create();

        final Tuple tempty = emptyTupleType.createTuple();
        System.out.println("\ntempty = " + tempty);

        // Should cause an error
        System.out.println("\nCreating tuple with wrong types: ");
        try {
            final Tuple terror = tripletTupleType.createTuple(1,2,3);
            System.out.println("Creating this tuple should have failed: " + terror);
        } catch (final IllegalArgumentException ex) {
            ex.printStackTrace(System.out);
        }

        // Should cause an error
        System.out.println("\nCreating tuple with wrong # of arguments: ");
        try {
            final Tuple terror = emptyTupleType.createTuple(1);
            System.out.println("Creating this tuple should have failed: " + terror);
        } catch (final IllegalArgumentException ex) {
            ex.printStackTrace(System.out);
        }

        // Should cause an error
        System.out.println("\nGetting value as wrong type: ");
        try {
            final Tuple t9 = tripletTupleType.createTuple(9,"nine",'i');
            final String verror = t9.getNthValue(0);
            System.out.println("Getting this value should have failed: " + verror);
        } catch (final ClassCastException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
