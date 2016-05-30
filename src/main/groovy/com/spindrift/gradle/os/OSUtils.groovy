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

/**
 * Created by hallatech on 29/05/2016.
 */
class OSUtils {

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
}