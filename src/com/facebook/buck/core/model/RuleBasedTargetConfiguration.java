/*
 * Copyright 2019-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.facebook.buck.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Optional;
import org.immutables.value.Value;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

/** Platform target implementation of {@link TargetConfiguration}. */
@Immutable(builder = false, copy = false, prehash = true)
public abstract class RuleBasedTargetConfiguration extends TargetConfiguration {

  @Value.Check
  protected void check() {
    ConfigurationForConfigurationTargets.validateTarget(getTargetPlatform());
  }

  @Parameter
  public abstract BuildTarget getTargetPlatform();

  @JsonIgnore
  @Override
  public Optional<BuildTarget> getConfigurationTarget() {
    return Optional.of(getTargetPlatform());
  }

  @Override
  public String toString() {
    return getTargetPlatform().toString();
  }
}
