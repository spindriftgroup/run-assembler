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

import com.spindrift.gradle.os.OSUtils

import org.gradle.api.Project

/**
 * Builds target paths absed on configuration
 * Created by hallatech on 07/06/2016.
 */
class TargetPathBuilder {

    static String getOutputParentPath(Project project) {

        def targetDir = project.runAssembler.outputDir

        File targetPath = (project.runAssembler.buildLocal) ?
                project.file("${project.buildDir}/${targetDir}") :
                project.file(targetDir)
        if (!targetPath.exists() && project.runAssembler.createOutputDir) {
            targetPath.mkdirs()
        }
        assert targetPath.exists()

        targetPath.toString()
    }

    static String getOutputDirPath(Project project, String assemblyName) {

        def assembly = project.runAssembler.assembly.find { it.name == assemblyName}
        def targetPath = getOutputParentPath(project)

        if (OSUtils.isWindows()) {
            "${trimPath(targetPath)}\\${assembly.outputFileName}"
        } else {
            "${trimPath(targetPath)}/${assembly.outputFileName}"
        }
    }

    private static String trimPath(String pathName) {
        if (pathName.endsWith('/') || pathName.endsWith('\\')) {
            pathName[0..-2]
        }
        else {
            pathName
        }
    }


}
