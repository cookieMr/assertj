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
package org.assertj.core.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author Mariusz Smykula
 */
class Hexadecimals_Test {

  @Test
  void should_return_hexadecimal_representation_of_byte() {
    assertThat(Hexadecimals.byteToHexString((byte) 0x00)).isEqualTo("00");
    assertThat(Hexadecimals.byteToHexString((byte) 0xFF)).isEqualTo("FF");
    assertThat(Hexadecimals.byteToHexString((byte) 0xa2)).isEqualTo("A2");
  }

}
