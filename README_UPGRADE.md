# Java 21 Upgrade (local guidance)

This project did not include a build system. To upgrade the project runtime to Java 21 (latest LTS), follow the steps below.

1) Install JDK 21

- On Debian/Ubuntu (if packages available) or prefer Adoptium/Eclipse Temurin or SDKMAN:

  - SDKMAN (recommended for developers):
    - curl -s "https://get.sdkman.io" | bash
    - source "$HOME/.sdkman/bin/sdkman-init.sh"
    - sdk install java 21.0.0-tem

  - Adoptium/Temurin (manual): download from https://adoptium.net/ and install.

2) Set JAVA_HOME and PATH

  - Example (bash):

    export JAVA_HOME="/path/to/jdk-21"
    export PATH="$JAVA_HOME/bin:$PATH"

3) Build with Maven (project now includes a minimal `pom.xml` at project root)

  - Install Maven if needed: `sudo apt install maven` or use SDKMAN: `sdk install maven`.
  - Verify: `mvn -version` (should show Java 21)
  - Build: `mvn -T 1C -DskipTests package`

4) Configure Eclipse (if you use Eclipse IDE)

  - Window → Preferences → Java → Installed JREs: Add JDK 21 and set it as default for the workspace if desired.
  - Project → Properties → Java Compiler: set the Compiler compliance level to 21.

5) After build

  - Fix any compile errors due to removed/changed APIs or modules. Typical steps may include updating library versions.
  - Run tests and adjust code for API changes.

Notes

- I added a minimal `pom.xml` set to `<release>21</release>` so the project can be built with JDK 21 using Maven.
- If you prefer Gradle or want me to convert the project to Gradle, tell me and I can add a `build.gradle` with toolchains targeting Java 21.
