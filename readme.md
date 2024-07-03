Simple Usage example for the Extism Java SDK
---

This is a simple example for using the [java-sdk](https://github.com/extism/extism/tree/main/java) of
the [extism](https://extism.org/) web-assembly plugin system with a JVM application.

# Setup
The extism library uses a native library written in rust to load and execute web-assembly code.
Therefore it is required to install the `extism` library in the library path, see https://extism.org/docs/install.

Alternatively the path to the `extism` library can also be specified via the system property `-Djna.library.path=/path/to/exitsm/lib`

# Build
```
mvn verify
``` 

# Run

via `exec-maven-plugin`:
```
mvn compile exec:java -Dexec.mainClass="example.ExtismExample"
```

or plain java launcher:

```
$ java -cp target/extism-java-example-jar-with-dependencies.jar example.ExtismExample "src/main/resources/code.wasm" count_vowels "Hello World"
```

Example output:
```
Executing "count_vowels" from "src/main/resources/code.wasm" with input "Hello World"
{"count": 3}
```
