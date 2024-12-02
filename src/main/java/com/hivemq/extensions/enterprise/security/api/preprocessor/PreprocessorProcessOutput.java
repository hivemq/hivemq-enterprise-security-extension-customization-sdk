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

package com.hivemq.extensions.enterprise.security.api.preprocessor;

import com.hivemq.extension.sdk.api.annotations.DoNotImplement;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.async.Async;
import com.hivemq.extensions.enterprise.security.api.model.EseVariablesOutput;

/**
 * The general process output for a preprocessor.
 *
 * @author Mario Schwede
 * @since 4.35.0
 */
@DoNotImplement
public interface PreprocessorProcessOutput<T extends PreprocessorProcessOutput<T>> {

    /**
     * Mark this operation as async.
     * <p>
     * Make sure to always call {@link Async#resume()} independent of a successful or unsuccessful operation.
     *
     * @return An {@link Async} object containing the {@link PreprocessorProcessOutput}.
     * @since 4.35.0
     */
    @NotNull Async<T> async();

    /**
     * @return The output for write access to the current state of the ESE variables.
     * @since 4.35.0
     */
    @NotNull EseVariablesOutput getEseVariablesOutput();

}
