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
 * Simple validation of runAssembler configuration to match usage notes.
 * Created by hallatech on 29/05/2016.
 */
class RunAssemblerValidator {

    /**
     * Validates combinations of options according to runAssembler rules
     * @param project
     * @return
     */
    static validate(Project project) {

        project.runAssembler.assembly.each { assembly ->
            //outputFileName must exist
            if (!assembly.outputFileName) {
                throw new GradleException("outputFileName is undefined for the current assembly configuration: \n${assembly}")
            }
            //at least one module option must exist
            if (!assembly.modules) {
                throw new GradleException("At least one module is required for the current assembly configuration: \n${assembly}")
            }
            //invalid combination of collapse-class-path and run-in-place
            if (assembly.options.collapseClassPath && assembly.options.runInPlace) {
                throw new GradleException("collapseClassPath and runInPlace cannot be used together for the current assembly configuration: \n${assembly}")
            }
        }
    }

    /**
     * Validates if an assembly configuration with a given name exists
     * @param project
     * @param name
     * @return true if a configuration exists with the name
     */
    static isValidAssemblyName(Project project, String name) {
        (project.runAssembler.assembly.find { it.name == name}) ? true : false
    }
}
