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

import com.spindrift.gradle.config.AssemblyParametersContainer

import org.gradle.util.ConfigureUtil

/**
 * Created by hallatech on 28/05/2016.
 */

class RunAssemblerExtension {

    //@Input
    /**
     * List of assembly container parameters
     */
    private List<AssemblyParametersContainer> assembly = []
    List<AssemblyParametersContainer> getAssembly() {
        assembly
    }
    void setAssembly(Closure closure) {
        assembly.clear()
        AssemblyParametersContainer newAssembly = new AssemblyParametersContainer()
        ConfigureUtil.configure(closure, newAssembly)
        assembly.addAll(newAssembly)
    }
    void assembly(Closure closure) {
        AssemblyParametersContainer newAssembly = new AssemblyParametersContainer()
        ConfigureUtil.configure(closure, newAssembly)
        assembly.addAll(newAssembly)
    }

    /**
     * Target output directory
     */
    private String outputDir = 'atg'
    void outputDir(String outputDir) {
        this.outputDir = outputDir
    }

    /**
     * Build target EAR in local build dir
     */
    private boolean buildLocal = true
    void buildLocal(boolean buildLocal) {
        this.buildLocal = buildLocal
    }

    /**
     * Create output directory if it does not exist
     */
    private boolean createOutputDir = true
    void createOutputDir(boolean createOutputDir) {
        this.createOutputDir = createOutputDir
    }
}
