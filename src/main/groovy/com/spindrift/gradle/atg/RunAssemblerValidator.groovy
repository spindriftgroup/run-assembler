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
package com.spindrift.gradle.atg

import org.gradle.api.Project
import org.gradle.api.GradleException

/**
 * Created by hallatech on 29/05/2016.
 */
class RunAssemblerValidator {

    static validate(Project project) {

        project.runAssembler.assembly.each { assembly ->
            if (!assembly.outputFileName) {
                throw new GradleException("outputFileName is undefined for the current assembly configuration: \n${assembly}")
            }
        }

    }
}
