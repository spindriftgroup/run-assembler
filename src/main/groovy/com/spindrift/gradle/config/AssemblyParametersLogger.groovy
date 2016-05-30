/**
 * Copyright 2016 Spindrift
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
package com.spindrift.gradle.config

import org.gradle.api.Project

/**
 * Created by hallatech on 29/05/2016.
 */
class AssemblyParametersLogger {

    /**
     * Prints the configured values of an extension properties assembly container
     * @return
     */
    static logPropertyValues(Project project) {

        project.runAssembler.assembly.each {
            project.logger.lifecycle "${it}"
        }
    }

    static logPropertyValues(Project project, AssemblyParametersContainer assembly) {
        project.logger.lifecycle "${assembly}"
    }
}
