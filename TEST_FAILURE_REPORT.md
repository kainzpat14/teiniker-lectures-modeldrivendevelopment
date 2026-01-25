# Test Failure Report

Generated: 2026-01-25
Java Version: OpenJDK 21.0.9

## Summary

**Test Results:**
- Total Testable Projects: 102
- Tests Passed: 77 (75.5%)
- Tests Failed: 17 (16.7%)
  - Semester marker issues: 9 projects
  - JDBC configuration: 5 projects
  - Module system issues: 2 projects
  - Groovy compilation: 1 project
- Tests Timeout: 2 (2.0%) - Console interactive
- No Tests: 6 (5.9%) - Valid, library projects

**Success Rate:** 77/96 = 80.2% (excluding timeout and student starter)

## Failure Categories

### 1. Missing jdbc.properties Configuration (5 projects)

**Projects:**
- `code-generation/Generator-DAO`
- `code-generation/Integration-DAO`
- `code-generation/Integration-LoggingDecorator`
- `code-generation/Integration-MonitoringDecorator`
- `generic-libraries/java/Java-Generics-DAO-Solution`

**Error:**
```
java.lang.IllegalStateException: Unable to load jdbc.properties!
```

**Root Cause:** Tests require a `jdbc.properties` file that is missing from the test resources.

---

### 2. Java Module System Reflection Issue (1 project)

**Project:**
- `code-generation/Integration-DependencyInjection`

**Error:**
```
java.lang.reflect.InaccessibleObjectException: Unable to make protected final java.lang.Class 
java.lang.ClassLoader.defineClass(...) accessible: module java.base does not "opens java.lang" 
to unnamed module
```

**Root Cause:** Google Guice dependency injection framework uses deep reflection that is restricted by Java module system (Java 9+). Needs JVM argument `--add-opens java.base/java.lang=ALL-UNNAMED`.

---

### 3. Semester Marker Path Issues - Missing Files (9 projects)

These tests are looking for generated files in old paths with semester markers (`ws2020`, `ss2020`) that no longer exist after our cleanup.

**Projects with NoSuchFileException:**

1. `previous_labexams/codegeneration/LabExam-CodeGeneration-Function-A2-Kainz`
   - Missing: `src/gen/java/at/fhj/mdd/ws2020/FunctionPipeline.java`
   - Should be: `src/gen/java/at/fhj/mdd/FunctionPipeline.java`

2. `previous_labexams/codegeneration/LabExam-CodeGeneration-Installer-Gruppe2-Kainz`
   - Missing: `src/gen/java/at/fhj/mdd/ws2020/MyInstallExecutor.java`
   - Should be: `src/gen/java/at/fhj/mdd/MyInstallExecutor.java`

3. `previous_labexams/codegeneration/LabExam-CodeGeneration-Quest-Gruppe1-Kainz`
   - Missing: `src/gen/java/at/fhj/mdd/ws2020/HealThePrincessQuestExecutor.java`
   - Should be: `src/gen/java/at/fhj/mdd/HealThePrincessQuestExecutor.java`

4. `previous_labexams/codegeneration/LabExam-WH-CodeGeneration-Jenkins-Gruppe1-Kainz`
   - Missing: `src/gen/java/at/fhj/mdd/ss2020/TestCodeSimulator.java`
   - Should be: `src/gen/java/at/fhj/mdd/TestCodeSimulator.java`
   - Also has assertion failure (whitespace issue)

5. `previous_labexams/codegeneration/LabExam-WH-CodeGeneration-Jenkins-Gruppe1-SWD19`
   - Missing: `src/gen/java/at/fhj/mdd/ss2020/TestCodeSimulator.java`
   - Should be: `src/gen/java/at/fhj/mdd/TestCodeSimulator.java`
   - Also has assertion failure (whitespace issue)

6. `previous_labexams/codegeneration/LabExam-WH-CodeGeneration-Logic-Gruppe2-Kainz`
   - Missing: `src/gen/java/at/fhj/mdd/ss2020/CircuitSimulator.java`
   - Should be: `src/gen/java/at/fhj/mdd/CircuitSimulator.java`

**Projects with Incorrect Import Statements:**

7. `previous_labexams/codegeneration/LabExam-CodeGeneration-Telegram-Gruppe1-Kainz`
   - Expected: `import at.fhj.mdd.ss2020.annotations...`
   - Generated: `import at.fhj.mdd.annotations...`
   - Generator code needs to be updated to use correct package

8. `previous_labexams/codegeneration/LabExam-CodeGeneration-Telegram-Gruppe2-Kainz`
   - Expected: `import at.fhj.mdd.ss2020.annotations...`
   - Generated: `import at.fhj.mdd.annotations...`
   - Generator code needs to be updated to use correct package

**Root Cause:** Test code and/or generator code still references old semester-specific paths. Need to update:
- File paths in generator visitor classes
- Expected output paths in test assertions
- Import statement generation in code generators

---

### 4. Console-Interactive Tests (2 projects - TIMEOUT)

**Projects:**
- `code-generation/Integration-TemplateMethod`
- `previous_labexams/codegeneration/LabExam-CodeGeneration-Adventure-WH-Kainz`

**Root Cause:** Tests contain code that reads from System.in (console input), causing the test to hang waiting for user input.

---

### 5. Groovy Compilation Order Issue (1 project)

**Project:**
- `code-generation/templating/java/Generator-Groovy`

**Error:**
```
cannot find symbol: class GroovyEntityGenerator
```

**Root Cause:** With gmavenplus-plugin, Groovy source files need to be compiled before Java test files that reference them. The plugin configuration may need adjustment for proper compilation order.

---

### 6. Lombok Module System Issue (1 project)

**Project:**
- `frameworks/Lombok-Demo`

**Error:**
```
java.lang.IllegalAccessError: class lombok.javac.apt.LombokProcessor cannot access class
com.sun.tools.javac.processing.JavacProcessingEnvironment because module jdk.compiler does not
export com.sun.tools.javac.processing to unnamed module
```

**Root Cause:** Lombok 1.18.34 needs access to internal compiler classes. Requires JVM argument: `--add-opens jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED`.

---

### 7. Student Starter Project - Intentionally Incomplete (1 project)

**Project:**
- `guide/jaxb-custom-starter`

**Error:**
```
cannot find symbol: method marshal/unmarshal in CustomMarshaller
```

**Root Cause:** This is a student starter project. The methods are intentionally missing - students are supposed to implement them. This is an expected failure.

---

## Projects with No Tests (6 projects)

These are valid - some projects are libraries/utilities without tests:
- `code-generation/Generator-cpp`
- `frameworks/Java-AnnotationProcessing`
- `generic-libraries/groovy/Groovy-Metaprogramming`
- `generic-libraries/groovy/Groovy-Metaprogramming-Transformer`
- `metamodeling/Metamodel-DOT-DependencyGraph`
- `metamodeling/Metamodel-XML`

---

## Recommended Fixes

### High Priority (affects 9 projects)
1. **Update generator visitor classes** in lab exam projects to use correct package paths (remove ws2020/ss2020)
2. **Update test assertions** to expect correct package names without semester markers

### Medium Priority (affects 7 projects)
3. **Add jdbc.properties files** or make tests work without database configuration (5 projects)
4. **Add JVM arguments** for module system compatibility:
   - Guice: `--add-opens java.base/java.lang=ALL-UNNAMED` (1 project)
   - Lombok: `--add-opens jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED` (1 project)
5. **Fix Groovy compilation order** in gmavenplus-plugin configuration (1 project)

### Low Priority (affects 2 projects)
6. **Mark console-interactive tests** with @Ignore or create mock input streams

### No Action Required (1 project)
7. **jaxb-custom-starter** - Student starter project, intentionally incomplete
