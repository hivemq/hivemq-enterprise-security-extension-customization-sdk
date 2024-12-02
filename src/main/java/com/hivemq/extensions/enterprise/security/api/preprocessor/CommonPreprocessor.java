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

import com.hivemq.extension.sdk.api.annotations.NotNull;

/**
 * The interface to implement a common preprocessor.
 * A common preprocessor can be used on any type of pipeline
 * because it only provides input that is independent of the pipeline type.
 *
 * @author Mario Schwede
 * @since 4.35.0
 */
@FunctionalInterface
public interface CommonPreprocessor {

    /**
     * The optional callback method to implement the initialization logic.
     *
     * @param input The input to access the init state.
     */
    default void init(final @NotNull CommonPreprocessorInitInput input) {
    }

    /**
     * The callback method to implement the processing logic.
     * <p>
     * The process method is called by multiple threads concurrently and must be thread-safe.
     * Also, the processing logic is responsible for its own exception handling and must not throw an {@link Exception}.
     *
     * @param input  The input to access the current process state.
     * @param output The output to update the current process state.
     */
    void process(@NotNull CommonPreprocessorProcessInput input, @NotNull CommonPreprocessorProcessOutput output);

    /**
     * The optional callback method to implement the shutdown logic.
     * The method is also called
     * in case {@link CommonPreprocessor#init(CommonPreprocessorInitInput)} could not finish successfully.
     *
     * @param input The input to access the shutdown state.
     */
    default void shutdown(final @NotNull CommonPreprocessorShutdownInput input) {
    }
}
