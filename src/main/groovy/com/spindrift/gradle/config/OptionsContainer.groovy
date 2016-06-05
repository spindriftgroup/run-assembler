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
    private List<String> collapseExcludeDirs = []
    List<String> getCollapseExcludeDirs() {
        CollectionUtils.stringize(this.collapseExcludeDirs)
    }
    void setCollapseExcludeDirs(Object... args) {
        this.collapseExcludeDirs.clear()
        this.collapseExcludeDirs.addAll(args as List)
    }
    void collapseExcludeDirs(Object... args) {
        this.collapseExcludeDirs.addAll(args as List)
    }
//-collapse-exclude-files
    private List<String> collapseExcludeFiles = []
    List<String> getCollapseExcludeFiles() {
        CollectionUtils.stringize(this.collapseExcludeFiles)
    }
    void setCollapseExcludeFiles(Object... args) {
        this.collapseExcludeFiles.clear()
        this.collapseExcludeFiles.addAll(args as List)
    }
    void collapseExcludeFiles(Object... args) {
        this.collapseExcludeFiles.addAll(args as List)
    }
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
    private String displayName
    void displayName(String displayName) {
        this.displayName = displayName
    }
//-server <servername>
    private String serverName
    void serverName(String serverName) {
        this.serverName = serverName
    }
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
    private List<String> addEarFile = []
    List<String> getAddEarFile() {
        CollectionUtils.stringize(this.addEarFile)
    }
    void setAddEarFile(Object... args) {
        this.addEarFile.clear()
        this.addEarFile.addAll(args as List)
    }
    void addEarFile(Object... args) {
        this.addEarFile.addAll(args as List)
    }
//-context-roots-file <properties file>
    private String contextRootsFile
    void contextRootsFile(String contextRootsFile) {
        this.contextRootsFile = contextRootsFile
    }
//-dynamo-env-properties <properties file>
    private String dynamoEnvProperties
    void dynamoEnvProperties(String dynamoEnvProperties) {
        this.dynamoEnvProperties = dynamoEnvProperties
    }
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
    private List<String> prependJars = []
    List<String> getPrependJars() {
        CollectionUtils.stringize(this.prependJars)
    }
    void setPrependJars(Object... args) {
        this.prependJars.clear()
        this.prependJars.addAll(args as List)
    }
    void prependJars(Object... args) {
        this.prependJars.addAll(args as List)
    }
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
    private String tomcatAdditionalResourcesFile
    void tomcatAdditionalResourcesFile(String tomcatAdditionalResourcesFile) {
        this.tomcatAdditionalResourcesFile = tomcatAdditionalResourcesFile
    }
//-tomcat-initial-resources-file <fileName>
    private String tomcatInitialResourcesFile
    void tomcatInitialResourcesFile(String tomcatInitialResourcesFile) {
        this.tomcatInitialResourcesFile = tomcatInitialResourcesFile
    }
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
collapseExcludeDirs:${collapseExcludeDirs},
collapseExcludeFiles:${collapseExcludeFiles},
jarDirs:${jarDirs},
verbose:${verbose},
classesOnly:${classesOnly},
displayName:${displayName},
server:${serverName},
liveConfig:${liveConfig},
distributable:${distributable},
addEarFile:${addEarFile},
contextRootsFile:${contextRootsFile},
dynamoEnvProperties:${dynamoEnvProperties},
excludeAccResources:${excludeAccResources},
noFix:${noFix},
prependJars:${prependJars},
runInPlace:${runInPlace},
tomcat:${tomcat},
tomcatAdditionalResourcesFile:${tomcatAdditionalResourcesFile},
tomcatInitialResourcesFile:${tomcatInitialResourcesFile},
tomcatUseJotm:${tomcatUseJotm},
tomcatUseAtomikos:${tomcatUseAtomikos},
jboss:${jboss}
"""
    }

}



