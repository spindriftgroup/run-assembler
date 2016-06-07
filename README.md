RunAssembler Gradle Plugin
==========================
Provides gradle wrapper functionality for the Oracle Commerce (ATG) runAssembler utility to assemble EARs

Notes and Licensing
===================
This plugin does not install Oracle Commerce (ATG) but assumes it is already installed and does not exclude 
the user from any Oracle licensing obligations.
This plugin is operational for *nix environments, is enabled for Windows but has not been tested on Windows.

Environmental Requirements
==========================

1. An Oracle Web Commerce (ATG) (10.x or later) must be installed containing the runAssembler script in $ATG_HOME/home/bin. The script must be on the system path e.g. in the users .bash_profile:

```
export ATG_HOME=/path/to/ATG/ATG11.2
export PATH=$PATH:$ATG_HOME/home/bin
or
export ATG_HOME=/path/to/ATG/ATG11.2/home
export DYNAMO_HOME=$ATG_HOME/home
export PATH=$PATH:$DYNAMO_HOME/bin
```

2. The ATGJRE environment variable must be set otherwise the java security policy will not be found, e.g. in the users .bash_profile:

```
export ATGJRE=$JAVA_HOME/bin/java
```

Usage
=====
To use the plugin, include it in your build script:

```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.spindrift.gradle:run-assembler:0.1.0-SNAPSHOT'
    }
}

apply plugin: 'com.spindrift.run-assembler'
```

Custom Task Types
=================
RunAssembler - Executes the runAssembler utilitity
RunAssemblerProperties - Prints the currently configured assembly parameters

Extension Properties
====================

Top level properties:

Property | Default Value | Description 
-------- | ------------- | -----------
outputDir | atg (relative to build directory) | The target output directory for the EAR(s).
buildLocal | true | Targets the project's build directory. If false set outputDir to absolute path.
createOutputDir | true | Will create the target directory if it does not exist, else throws a Gradle exception.
atgHomeEnvVar | ATG_HOME | Set the ATG HOME variable to use for finding the runAssembler utility.
deleteEars | true | Delete any existing EARs prior to assembly.


Assembly configuration:
One or more assembly configurations for each EAR using:
```
runAssembler {
    assembly {
        ...
    }
    assembly {
        ...
    }
}
```
Property | Type | Default Value | Matched runAssembler parameter
-------- | ------------- | ------------------------------
name* | String | none <required> | Not applicable. For requesting gradle CLI using -Papp=name
outputFileName* | String | none <required> | -output-file-name
modules* | List<String> | none <required> | -m
layers | List<String> | none <optional> | -layer (This is optional but separate from the opions container)
options | Closure | none <optional> | See options below

Options configuration:
Optional parameters per assembly:
```
runAssembler {
    assembly {
        ...
        options {
            ...
        }
    }
}
```
Property | Type | Default Value | Matched runAssembler parameter
-------- | ------------- | ------------------------------
pack | boolean | false | -pack
standalone | boolean | false | -standalone
overwrite | boolean | false | -overwrite
collapseClassPath | boolean| false | -collapse-class-path
collapseExcludeDirs | List<String>  | [] | -collapse-exclude-dirs
collapseExcludeFiles | List<String> | [] | -collapse-exclude-files
jarDirs | boolean | false | -jardirs
verbose | boolean | false | -verbose
classesOnly | boolean | false | -classesonly
displayName | String | '' | -displayname <name>
serverName | String | '' | -server
liveConfig | boolean | false | -liveconfig
distributable | boolean | false | -distributable
addEarFile | List<String> | [] | -add-ear-file <EAR file name>
contextRootsFile | String | '' | -context-roots-file <properties file>
dynamoEnvProperties | String | '' | -dynamo-env-properties <properties file>
excludeAccResources | boolean | false | -exclude-acc-resources
noFix | boolean | false | -nofix
prependJars | List<String> | [] | -prependJars <jar1,jar2,...>
runInPlace | boolean | false | -run-in-place
tomcat | boolean | false | -tomcat
tomcatAdditionalResourcesFile | String | false | -tomcat-additional-resources-file <fileName>
tomcatInitialResourcesFile | String | false | -tomcat-initial-resources-file <fileName>
tomcatUseJotm | boolean | false | -tomcat-use-jotm
tomcatUseAtomikos | boolean | false | -tomcat-use-atomikos
jboss | boolean | false | -jboss


Example Configuration
=====================
```
runAssembler {
    assembly {
        name 'live'
        outputFileName 'ATGProduction.ear'
        modules 'DAS', 'DPS', 'DSS', 'DCS', 'MyModule'
        layers 'storefront-local', 'storefront-test', 'storefront-uat', 'storefront-prod'
        options {
            standalone true
            liveConfig true
            jboss true
        }
    }
    assembly {
        name 'ca'
        outputFileName 'ATGPublishing.ear'
        modules 'DAS.Versioned', 'DPS.Versioned', 'DSS.Versioned', 'DCS.Versioned, 'MyModule.Versioned'
        layers 'bcc-local', 'bcc-test', 'bcc-uat', 'bcc-prod'
        options {
            standalone true
            liveConfig true
            jboss true
        }
    }
}
```
See integration-test/build.gradle for more examples

By default the EAR(s) will be built in an _atg_ sub-directory of the project's build directory at _build/atg_
To target a remote directory, set buildLocal to false and specify an absolute path. The target output settings are global.
```
runAssembler {
    buildLocal false
    outputDir   '/some/remote/path'
    createOutputDir true //default
    assembly {
        ...
    }
    assembly {
        ...
    }
}
```

Execution
=========
Use *gradle*, *./gradlew* or relevant alias as appropriate.
```
gradle runAssembler
gradle runAssembler -i  //for additional output
gradle runAssembler -Papp=<appName>
gradle runAssembler -PshowProperties
gradle runAssemblerProperties
```

Build Notes
===========
The default task is build plus a local maven install so that the integration test can immediately be executed.
The integration tests are execute separately by switching to the integration-test directory and running the relevant 
execution command as above after configuration the build.gradle with examples. 
