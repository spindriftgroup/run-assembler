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
package com.spindrift.gradle.atg.tasks

import com.spindrift.gradle.atg.RunAssemblerValidator
import com.spindrift.gradle.config.AssemblyParametersLogger

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction


/**
 * Wrapper task for executing runAssembler utility.
 * It iterates over a list of script configurations which define the parameters for each assembly.
 * Created by hallatech on 28/05/2016.
 */
class RunAssembler extends DefaultTask {

    static final String TASK_DESCRIPTION = "Assembles an Oracle Commerce (ATG) EAR."
    static final String TASK_GROUP = "Oracle Commerce"

    RunAssembler() {
        description = TASK_DESCRIPTION
        group = TASK_GROUP
    }

    @TaskAction
    public void executeCommandLine() {

        RunAssemblerValidator.validate(project)

        if (project.hasProperty('showProperties')) {
            AssemblyParametersLogger.logPropertyValues(project)
        }

    }

}
