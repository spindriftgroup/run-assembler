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

import com.spindrift.gradle.atg.RunAssemblerValidator
import org.gradle.util.ConfigureUtil
import org.gradle.util.CollectionUtils

/**
 * Created by hallatech on 29/05/2016.
 */
class AssemblyParametersContainer {

    //@Input
    /**
     * output-file-name input property
     */
    private String outputFileName
    void outputFileName(String outputFileName) {
        this.outputFileName = outputFileName
    }

    /**
     * modules input property
     */
    private List<String> modules = []
    List<String> getModules() {
        CollectionUtils.stringize(this.modules)
    }
    void setModules(Object... args) {
        this.modules.clear()
        this.modules.addAll(args as List)
    }
    void modules(Object... args) {
        this.modules.addAll(args as List)
    }

    /**
     * layers input property
     */
    private List<String> layers = []
    List<String> getLayers() {
        CollectionUtils.stringize(this.layers)
    }
    void setLayers(Object... args) {
        this.layers.clear()
        this.layers.addAll(args as List)
    }
    void layers(Object... args) {
        this.layers.addAll(args as List)
    }

    /**
     * Container of optional parameters in a sub-closure
     */
    private OptionsContainer options = new OptionsContainer()
    void options(Closure closure) {
        ConfigureUtil.configure(closure, options)
    }

    def validate() {
        RunAssemblerValidator.validate(this)
    }

    @Override
    public String toString() {
        """outputFileName:${this.outputFileName},
modules:${this.modules.join(',')},
layers:${this.layers.join(',')},
options:${this.options}"""
    }

}
