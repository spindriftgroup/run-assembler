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

import com.spindrift.gradle.config.AssemblyParametersLogger

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Shows property configuration runAssembler task.
 * Created by hallatech on 28/05/2016.
 */
class RunAssemblerProperties extends DefaultTask {

    static final String TASK_DESCRIPTION = "Shows task configuration properties for the runAssembler task"
    static final String TASK_GROUP = "Oracle Commerce"

    RunAssemblerProperties() {
        description = TASK_DESCRIPTION
        group = TASK_GROUP
    }

    @TaskAction
    public void exec() {
        if (project.hasProperty('app') && project.app) {
            AssemblyParametersLogger.logPropertyValues(project, project.runAssembler.assembly.find { it.name == project.app})
        }
        else {
            AssemblyParametersLogger.logPropertyValues(project)
        }
    }

}
