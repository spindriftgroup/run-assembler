/**
 * Copyright 2012 Spindrift
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

/**
 * A container for optional parameters
 * @author hallatech
 */
import groovy.transform.AutoClone

@AutoClone
class OptionsContainer {

//-pack
    private boolean pack = false
    void pack(boolean pack) {
        this.pack = pack
    }
//-standalone
    private boolean standalone = false
    void standalone(boolean standalone) {
        this.standalone = standalone
    }
//-overwrite
    private boolean overwrite = false
    void overwrite(boolean overwrite) {
        this.overwrite = overwrite
    }
//-collapse-class-path
    private boolean collapseClassPath = false
    void collapseClassPath(boolean collapseClassPath) {
        this.collapseClassPath = collapseClassPath
    }
//-collapse-exclude-dirs
//-collapse-exclude-files
//-jardirs
    private boolean jarDirs = false
    void jarDirs(boolean jarDirs) {
        this.jarDirs = jarDirs
    }
//-verbose
    private boolean verbose = false
    void verbose(boolean verbose) {
        this.verbose = verbose
    }
//-classesonly
    private boolean classesOnly = false
    void classesOnly(boolean classesOnly) {
        this.classesOnly = classesOnly
    }
//-displayname <name>
//-server <servername>
//-liveconfig
    private boolean liveConfig = false
    void liveConfig(boolean liveConfig) {
        this.liveConfig = liveConfig
    }
//-distributable
    private boolean distributable = false
    void distributable(boolean distributable) {
        this.distributable = distributable
    }
//-add-ear-file <EAR file name>
//-context-roots-file <properties file>
//-dynamo-env-properties <properties file>
//-exclude-acc-resources
    private boolean excludeAccResources = false
    void excludeAccResources(boolean excludeAccResources) {
        this.excludeAccResources = excludeAccResources
    }
//-nofix
    private boolean noFix = false
    void noFix(boolean noFix) {
        this.noFix = noFix
    }
//-prependJars <jar1,jar2,...>
//-run-in-place
    private boolean runInPlace = false
    void runInPlace(boolean runInPlace) {
        this.runInPlace = runInPlace
    }
//-tomcat
    private boolean tomcat = false
    void tomcat(boolean tomcat) {
        this.tomcat = tomcat
    }
//-tomcat-additional-resources-file <fileName>
//-tomcat-initial-resources-file <fileName>
//-tomcat-use-jotm
    private boolean tomcatUseJotm = false
    void tomcatUseJotm(boolean tomcatUseJotm) {
        this.tomcatUseJotm = tomcatUseJotm
    }
//-tomcat-use-atomikos
    private boolean tomcatUseAtomikos = false
    void tomcatUseAtomikos(boolean tomcatUseAtomikos) {
        this.tomcatUseAtomikos = tomcatUseAtomikos
    }
//-jboss
    private boolean jboss = false
    void jboss(boolean jboss) {
        this.jboss = jboss
    }

    @Override
    public String toString() {
        """pack:${pack},
standalone:${standalone},
overwrite:${overwrite},
collapseClassPath:${collapseClassPath},
jarDirs:${jarDirs},
verbose:${verbose},
classesOnly:${classesOnly},
liveConfig:${liveConfig},
distributable:${distributable}
excludeAccResources:${excludeAccResources}
noFix:${noFix},
runInPlace:${runInPlace},
tomcat:${tomcat},
tomcatUseJotm:${tomcatUseJotm},
tomcatUseAtomikos:${tomcatUseAtomikos},
jboss:${jboss}
"""
    }

}



