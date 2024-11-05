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
import com.hivemq.extension.sdk.api.annotations.Experimental;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.packets.connect.ConnectPacket;
import com.hivemq.extension.sdk.api.parameter.ClientBasedInput;

/**
 * The input for the processing of an {@link MqttPreprocessor}.
 *
 * @author Mario Schwede
 * @since 4.35.0
 */
@Experimental
@DoNotImplement
public interface MqttPreprocessorProcessInput extends PreprocessorProcessInput, ClientBasedInput {

    /**
     * Provides the unmodifiable CONNECT packet sent by the MQTT client that has to be authenticated.
     *
     * @return The {@link ConnectPacket} sent by the client.
     * @since 4.35.0
     */
    @NotNull ConnectPacket getConnectPacket();
}
