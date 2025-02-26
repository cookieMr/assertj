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
package org.assertj.core.error;

import static java.lang.String.format;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.error.ShouldBeEqualIgnoringMinutes.shouldBeEqualIgnoringMinutes;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;

import org.assertj.core.internal.TestDescription;
import org.assertj.core.presentation.StandardRepresentation;
import org.junit.jupiter.api.Test;

/**
 * Tests for <code>{@link org.assertj.core.error.ShouldBeEqualIgnoringMinutes#create(org.assertj.core.description.Description, org.assertj.core.presentation.Representation)}</code>.
 *
 * @author Alexander Bischof
 */
class ShouldBeEqualIgnoringMinutes_create_Test {

  @Test
  void should_create_error_message_for_LocalTime() {
    // GIVEN
    ErrorMessageFactory factory = shouldBeEqualIgnoringMinutes(LocalTime.of(12, 0), LocalTime.of(12, 1));
    // WHEN
    String message = factory.create(new TestDescription("Test"), new StandardRepresentation());
    // THEN
    then(message).isEqualTo(format("[Test] %n" +
                                   "Expecting actual:%n" +
                                   "  12:00%n" +
                                   "to have same hour as:%n" +
                                   "  12:01%n" +
                                   "but had not."));
  }

  @Test
  void should_create_error_message_for_OffsetTime() {
    // GIVEN
    ErrorMessageFactory factory = shouldBeEqualIgnoringMinutes(OffsetTime.of(12, 0, 0, 0, ZoneOffset.UTC),
                                                               OffsetTime.of(12, 1, 0, 0, ZoneOffset.UTC));
    // WHEN
    String message = factory.create(new TestDescription("Test"), new StandardRepresentation());
    // THEN
    then(message).isEqualTo(format("[Test] %n" +
                                   "Expecting actual:%n" +
                                   "  12:00Z%n" +
                                   "to have same hour as:%n" +
                                   "  12:01Z%n" +
                                   "but had not."));
  }
}
