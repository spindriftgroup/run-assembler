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
import com.spindrift.gradle.atg.tasks.helpers.RunAssemblerCommandLineBuilder
import com.spindrift.gradle.atg.tasks.helpers.RunAssemblerExecutor
import com.spindrift.gradle.atg.tasks.helpers.TargetPathBuilder
import com.spindrift.gradle.config.AssemblyParametersLogger

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction
import org.gradle.api.Project
/**
 * Wrapper task for executing runAssembler utility.
 * It iterates over a list of script configurations which define the parameters for each assembly.
 * Created by hallatech on 28/05/2016.
 */
class RunAssembler extends DefaultTask {

    static final String TASK_DESCRIPTION = "Assembles an Oracle Commerce (ATG) EAR."
    static final String TASK_GROUP = "Oracle Commerce"
    static final String SHOW_PROPERTIES_PARAM = "showProperties"

    RunAssembler() {
        description = TASK_DESCRIPTION
        group = TASK_GROUP
    }

    @TaskAction
    public void executeCommandLine() {

        RunAssemblerValidator.validate(project)

        if (project.hasProperty(SHOW_PROPERTIES_PARAM)) {
            AssemblyParametersLogger.logPropertyValues(project)
        }

        //process
        if (project.hasProperty('app') && project.app) {
            if (!RunAssemblerValidator.isValidAssemblyName(project, project.app)) {
                throw new GradleException("Invalid assembly name for parameter app=${project.app}")
            }
            def args = RunAssemblerCommandLineBuilder.build(project, project.app)
            deleteEarDir(project,project.app)
            project.logger.quiet "Executing runAssembler for assembly configuration ${project.app}"
            project.logger.info "with arguments ${args}"
            RunAssemblerExecutor.exec(project, args)
        }
        else {
            project.runAssembler.assembly.each { config ->
                def args = RunAssemblerCommandLineBuilder.build(project, config.name)
                deleteEarDir(project,config.name.toString())
                project.logger.quiet "Executing runAssembler for assembly configuration ${config.name}"
                project.logger.info "with arguments ${args}"
                RunAssemblerExecutor.exec(project, args)
            }

        }
    }

    /**
     * Optionally delete an existing EAR before executing the utility
     * @param project
     * @param app
     */
    def deleteEarDir(Project project, String app) {
        if (project.runAssembler.deleteEars) {
            File ear = project.file(TargetPathBuilder.getOutputDirPath(project, app))
            if (ear.exists()) {
                project.logger.info "Deleting existing EAR ${ear}"
                project.delete ear
            }
            assert !ear.exists()
        }
    }

}
