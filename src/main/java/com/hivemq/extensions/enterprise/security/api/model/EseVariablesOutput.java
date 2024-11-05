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
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

import java.nio.ByteBuffer;
import java.util.List;

/**
 * This output provides write access the current state of the ESE variables.
 * The updates are applied after completion of the particular preprocessor.
 *
 * @author Mario Schwede
 * @since 4.35.0
 */
@Experimental
@DoNotImplement
public interface EseVariablesOutput {

    /**
     * Sets the content of the ESE variable {@code authentication-key}.
     * The existing content of the ESE variable will be overwritten.
     * <p>
     * The variable content is used in the pipeline as the {@code username} for the configured authentication manager.
     *
     * @param authenticationKey The new content of the ESE variable {@code authentication-key}.
     * @since 4.35.0
     */
    void setAuthenticationKey(@Nullable String authenticationKey);

    /**
     * Sets the content of the ESE variable {@code authentication-byte-secret}.
     * The existing content of the ESE variable will be overwritten.
     * <p>
     * The variable content is used in the pipeline as the {@code password} for the configured authentication manager.
     *
     * @param authenticationByteSecret The new content of the ESE variable {@code authentication-byte-secret}.
     * @since 4.35.0
     */
    void setAuthenticationByteSecret(@Nullable ByteBuffer authenticationByteSecret);

    /**
     * Sets the content of the ESE variable {@code authorization-key}.
     * The existing content of the ESE variable will be overwritten.
     * <p>
     * The variable content is used in the pipeline as the {@code username} for the configured authorization manager.
     *
     * @param authorizationKey The new content of the ESE variable {@code authorization-key}.
     * @since 4.35.0
     */
    void setAuthorizationKey(@Nullable String authorizationKey);

    /**
     * Sets the content of the ESE variable {@code authorization-role-key}.
     * The existing content of the ESE variable will be overwritten.
     * <p>
     * The {@code authorization-role-key} is internally encoded as a string containing multiple roles
     * wrapped in double braces.
     * For example {@code {{role1}}{{role2}}{{role3}}}.
     * An empty list will be encoded as an empty string.
     * The decoded variable content is used in the pipeline as the {@code roles} for the configured authorization
     * manager.
     *
     * @param authorizationRoleKey The new decoded content of the ESE variable {@code authorization-role-key}.
     * @throws NullPointerException When the {@code authorizationRoleKey} contains at least one {@code null} value.
     * @since 4.35.0
     */
    void setAuthorizationRoleKey(@Nullable List<@NotNull String> authorizationRoleKey);

    /**
     * Sets the content of the string ESE variable with the provided name.
     * The existing content of the ESE variable will be overwritten.
     *
     * @param name  The name of the ESE variable.
     * @param value The new content of the ESE variable.
     * @throws IllegalArgumentException When the provided {@code name} is not usable.
     *                                  Usable names are either known string variables or general purpose variables that
     *                                  match the pattern {@code string-[a-z0-9\-]+}.
     * @throws IllegalArgumentException When the variable with the provided {@code name} is read-only.
     * @throws IllegalArgumentException When the variable with the provided {@code name} is not of type string.
     * @since 4.35.0
     */
    void setString(@NotNull String name, @Nullable String value);

    /**
     * Sets the content of the byte ESE variable with the provided name.
     * The existing content of the ESE variable will be overwritten.
     *
     * @param name  The name of the ESE variable.
     * @param value The new content of the ESE variable.
     * @throws IllegalArgumentException When the provided {@code name} is not usable.
     *                                  Usable names are either known byte variables or general purpose variables that
     *                                  match the pattern {@code byte-[a-z0-9\-]+}.
     * @throws IllegalArgumentException When the variable with the provided {@code name} is read-only.
     * @throws IllegalArgumentException When the variable with the provided {@code name} is not of type byte.
     * @since 4.35.0
     */
    void setByte(@NotNull String name, @Nullable ByteBuffer value);

    /**
     * Discards all changes previously applied to this output.
     */
    void reset();
}
