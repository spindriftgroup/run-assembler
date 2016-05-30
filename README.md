RunAssembler Gradle Plugin
==========================
Provides gradle wrapper functionality for the Oracle Commerce (ATG) runAssembler utility to assemble EARs

Environmental Requirements
==========================

1. An Oracle Web Commerce (ATG) (10.x or later) must be installed containing the startSQLImport script in $ATG_HOME/home/bin. The script must be on the system path e.g. in the users .bash_profile:

```
export ATG_HOME=/path/to/ATG/ATG11.1
export PATH=$PATH:$ATG_HOME/home/bin
or
export ATG_HOME=/path/to/ATG/ATG11.1/home
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

Example Configuration
=====================
```
runAssembler {
    assembly {
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


Execution
=========
```
gradle runAssembler
gradle runAssembler -PshowProperties
gradle runAssemblerProperties
```

Build Notes
===========
