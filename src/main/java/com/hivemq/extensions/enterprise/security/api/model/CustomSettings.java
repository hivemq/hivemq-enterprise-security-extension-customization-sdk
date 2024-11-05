/*
 * Copyright 2024-present HiveMQ GmbH
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
 */

package com.hivemq.extensions.enterprise.security.api.model;

import com.hivemq.extension.sdk.api.annotations.DoNotImplement;
import com.hivemq.extension.sdk.api.annotations.Experimental;
import com.hivemq.extension.sdk.api.annotations.Immutable;
import com.hivemq.extension.sdk.api.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A representation of {@code <custom-settings>} as it is configured.
 *
 * @author Mario Schwede
 * @since 4.35.0
 */
@Immutable
@Experimental
@DoNotImplement
public interface CustomSettings {

    /**
     * @param name The name of the custom setting to get.
     * @return An {@link Optional} that contains the first custom setting with the specified name.
     * @since 4.35.0
     */
    @NotNull Optional<String> getFirst(@NotNull String name);

    /**
     * @param name The name of the custom settings to get.
     * @return The values of the custom setting with the specified name.
     * @since 4.35.0
     */
    @Immutable @NotNull List<@NotNull String> getAllForName(@NotNull String name);

    /**
     * @return A list of all {@link CustomSetting}s.
     * @since 4.35.0
     */
    @Immutable @NotNull List<@NotNull CustomSetting> asList();

    /**
     * @return A map with the first value for every custom setting name.
     * @since 4.35.0
     */
    @Immutable @NotNull Map<@NotNull String, @NotNull String> asSingleValueMap();

    /**
     * @return <code>true</code> if no custom settings are present, else <code>false</code>.
     * @since 4.35.0
     */
    boolean isEmpty();
}
