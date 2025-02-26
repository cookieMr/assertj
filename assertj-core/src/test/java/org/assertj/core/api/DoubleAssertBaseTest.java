/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2025 the original author or authors.
 */
package org.assertj.core.api;

import static org.mockito.Mockito.mock;

import org.assertj.core.internal.Comparables;
import org.assertj.core.internal.Doubles;
import org.assertj.core.testkit.AlwaysEqualComparator;

/**
 * Base class for {@link DoubleAssert} tests.
 *
 * @author Olivier Michallat
 */
public abstract class DoubleAssertBaseTest extends BaseTestTemplate<DoubleAssert, Double> {

  protected static final AlwaysEqualComparator<Double> ALWAY_EQUAL_DOUBLE = new AlwaysEqualComparator<>();

  protected Doubles doubles;
  protected Comparables comparables;

  @Override
  protected DoubleAssert create_assertions() {
    return new DoubleAssert(Double.valueOf(3.14));
  }

  @Override
  protected void inject_internal_objects() {
    super.inject_internal_objects();
    doubles = mock(Doubles.class);
    assertions.doubles = doubles;
    comparables = mock(Comparables.class);
    assertions.comparables = comparables;
  }

  protected Doubles getDoubles(DoubleAssert someAssertions) {
    return someAssertions.doubles;
  }
}
