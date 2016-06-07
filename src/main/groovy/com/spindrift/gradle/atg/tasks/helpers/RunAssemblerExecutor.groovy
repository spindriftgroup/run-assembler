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
package com.spindrift.gradle.atg.tasks.helpers

import org.gradle.api.Project
import com.spindrift.gradle.os.OSUtils

/**
 * Executes the runAssembler utility
 * Created by hallatech on 07/06/2016.
 */
class RunAssemblerExecutor {

    static final RUN_ASSEMBLER_NIX='runAssembler'
    static final RUN_ASSEMBLER_WINDOWS='runAssembler.bat'
    static final ATG_HOME_VAR='ATG_HOME'

    static void exec(Project project, ArrayList<String> arguments) {

        def atgHome = OSUtils.getEnvVariable(ATG_HOME_VAR,true)
        def cliExecutable = (OSUtils.isWindows()) ?
                "${atgHome}\\home\\bin\\${RUN_ASSEMBLER_WINDOWS}" :
                "${atgHome}/home/bin/${RUN_ASSEMBLER_NIX}"

        project.logger.quiet "Executing: ${cliExecutable} ${arguments.join(' ')}"

        project.exec {
            executable = cliExecutable
            args = arguments
        }
    }
}
