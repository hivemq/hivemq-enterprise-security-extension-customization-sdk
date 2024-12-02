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
import com.hivemq.extension.sdk.api.annotations.Immutable;
import com.hivemq.extension.sdk.api.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;

/**
 * This input provides read access to the current state of the ESE variables.
 *
 * @author Mario Schwede
 * @since 4.35.0
 */
@Immutable
@DoNotImplement
public interface EseVariablesInput {

    /**
     * @return An {@link Optional} that contains the content of the ESE variable {@code authentication-key}.
     *         The variable content is used in the pipeline as the {@code username} for the configured authentication manager.
     * @since 4.35.0
     */
    @NotNull Optional<String> getAuthenticationKey();

    /**
     * @return An {@link Optional} that contains the content of the ESE variable {@code authentication-byte-secret}
     *         as a {@link ByteBuffer#asReadOnlyBuffer() read-only} {@link ByteBuffer}.
     *         The variable content is used in the pipeline as the {@code password} for the configured authentication manager.
     * @since 4.35.0
     */
    @NotNull Optional<ByteBuffer> getAuthenticationByteSecret();

    /**
     * @return An {@link Optional} that contains the content of the ESE variable {@code authorization-key}.
     *         The variable content is used in the pipeline as the {@code username} for the configured authorization manager.
     * @since 4.35.0
     */
    @NotNull Optional<String> getAuthorizationKey();

    /**
     * @return An {@link Optional} that contains the decoded content of the ESE variable
     *         {@code authorization-role-key}.
     *         The {@code authorization-role-key} is internally encoded as a string containing multiple roles
     *         wrapped in double braces.
     *         For example {@code {{role1}}{{role2}}{{role3}}}.
     *         An empty string will be decoded as an empty list.
     *         The decoded variable content is used in the pipeline as the {@code roles} for the configured
     *         authorization manager.
     * @since 4.35.0
     */
    @NotNull Optional<List<@NotNull String>> getAuthorizationRoleKey();

    /**
     * @param name The name of the string ESE variable to get.
     * @return An {@link Optional} that contains the content of the string ESE variable with the provided name.
     *         Is empty if the ESE variable does not exist, is {@code null} or is not of type string.
     * @since 4.35.0
     */
    @NotNull Optional<String> getString(@NotNull String name);

    /**
     * @param name The name of the byte ESE variable to get.
     * @return An {@link Optional} that contains the content of a byte ESE variable with the provided name
     *         as a {@link ByteBuffer#asReadOnlyBuffer() read-only} {@link ByteBuffer}.
     *         Is empty if the ESE variable does not exist, is {@code null} or is not of type byte.
     * @since 4.35.0
     */
    @NotNull Optional<ByteBuffer> getByte(@NotNull String name);
}
