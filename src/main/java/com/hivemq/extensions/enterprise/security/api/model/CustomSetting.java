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

/**
 * A representation of {@code <custom-setting>} as it is configured.
 *
 * @author Mario Schwede
 * @since 4.35.0
 */
@Immutable
@Experimental
@DoNotImplement
public interface CustomSetting {

    /**
     * @return The name of the custom setting.
     * @since 4.35.0
     */
    @NotNull String getName();

    /**
     * @return The value of the custom setting.
     * @since 4.35.0
     */
    @NotNull String getValue();
}
