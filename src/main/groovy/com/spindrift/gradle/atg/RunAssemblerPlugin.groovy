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

import com.spindrift.gradle.atg.tasks.RunAssembler
import com.spindrift.gradle.atg.tasks.RunAssemblerProperties
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Provides wrapper functionality for Oracle Web Commerce's runAssembler EAR assembly tool.
 * CLI Usage: runAssembler [option*] output-file-name [-layer config-layer-list] -m dynamo-module-list

 * Created by hallatech on 28/05/2016.
 */
class RunAssemblerPlugin implements Plugin<Project> {

    static final String PLUGIN_EXTENSION_NAME="runAssembler"
    static final String RUN_ASSEMBLER_TASK="runAssembler"
    static final String RUN_ASSEMBLER_PROPERTIES_TASK="runAssemblerProperties"

    @Override
    public void apply(Project project) {
        project.extensions."${PLUGIN_EXTENSION_NAME}" = new RunAssemblerExtension()
        addRunAssemblerTask(project)
        addRunAssemblerPropertiesTask(project)
    }

    private void addRunAssemblerTask(Project project) {
        project.task(RUN_ASSEMBLER_TASK, type: RunAssembler )
    }

    private void addRunAssemblerPropertiesTask(Project project) {
        project.task(RUN_ASSEMBLER_PROPERTIES_TASK, type: RunAssemblerProperties )
    }
}
