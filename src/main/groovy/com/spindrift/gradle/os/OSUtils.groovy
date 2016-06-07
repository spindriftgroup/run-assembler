/**
 * Copyright 2012 Spindrift
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spindrift.gradle.os

import org.gradle.api.GradleException
import static org.gradle.api.logging.Logging.getLogger

/**
 * Created by hallatech on 29/05/2016.
 */
class OSUtils {

    private static final String LOGGER='system.out'

    /**
     * Gets the Operating System type
     * @return
     */
    static String getOSType() {
        def osType=''
        def os = System.getProperty("os.name").toLowerCase()
        if (os.contains("windows")) { osType="windows" }
        else if (os.contains("mac os")) { osType="mac" }
        else { osType="linux" } // assume Linux
        return osType
    }

    /**
     * Confirms if running on a Windows based O/S
     * @return
     */
    static boolean isWindows() {
        return (getOSType().equals("windows")) ? true : false
    }

    /**
     * Gets an environment variable
     * @param name the name of the environment variable
     * @param failIfNotExists throw exception if variable not found
     * @return the variable
     */
    static String getEnvVariable(String name, boolean failIfNotExists) {
        def envVar = System.getenv(name)
        if (envVar == null) {
            if (failIfNotExists) {
                throw new GradleException("Requested environment variable ${name} not found. This is requirement to continue, please set and try again.")
            }
            else {
                getLogger(LOGGER).warn("Requested environment variable ${name} not found. Unexpected results may occur.")
            }
        }
        return envVar
    }
}