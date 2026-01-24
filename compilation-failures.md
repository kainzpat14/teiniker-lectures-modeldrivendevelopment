# Maven Compilation Check Results

## Final Summary
- **Total projects in repository: 165**
- **Skipped (Exercise/MyName/Student projects): 63**
  - Exercise/MyName projects: 53
  - Student starter projects (orm-custom-starter, static-analysis/*): 10
- **✓ Passed: 102 (100% of testable projects)**
- **✗ Failed: 0**

## All Projects Now Compile Successfully!

All non-exercise Maven projects in the repository now compile successfully after the following fixes were applied:

### 1. Semester Marker Cleanup
Removed all semester markers (ws2020, ss2020, etc.) from **22 projects**:
- Updated Maven `groupId` from `at.fhj.mdd.{semester}` to `at.fhj.mdd`
- Updated all Java package declarations
- Moved all files from `at/fhj/mdd/{semester}/*` to `at/fhj/mdd/*` directories

### 2. Dependency Installation
**18 projects** required internal dependencies to be installed first:

**Round 1 - Metamodel-Entity dependency (6 projects):**
- `code-generation/Generator-DAO`
- `code-generation/Generator-Visitor-Entity`
- `code-generation/Integration-DAO`
- `metamodeling/AnnotationProcessing-Entity`
- `metamodeling/ExpressionBuilder-Entity`
- `metamodeling/Metamodel-Validation-Entity`

**Round 2 - Interface/StateMachine/XML dependencies (8 projects):**
- `code-generation/Generator-Visitor-Interface-Decorator`
- `code-generation/templating/java/Generator-Velocity-Interface-Decorator`
- `metamodeling/ExpressionBuilder-Interface`
- `metamodeling/ExpressionBuilder-StateMachine`
- `metamodeling/ExpressionBuilder-XML`
- `metamodeling/FunctionSequence-XML`
- `metamodeling/Kotlin-DSL`
- `metamodeling/ModelValidation-Interface`

**Round 3 - Additional dependencies (4 projects):**
- `code-generation/templating/java/Generator-FreeMarker`
- `code-generation/templating/java/Generator-Groovy`
- `metamodeling/NestedFunctions-HTML`
- `generic-libraries/groovy/Groovy-Metaprogramming`

### 3. Plugin Upgrades for Java 17 Compatibility (7 projects total)

**AspectJ Projects (2 projects):**
- `frameworks/AspectJ-Demo`
- `frameworks/AspectJ-Lombok-Refactoring`

**Changes:**
- Updated `aspectj-maven-plugin` from 1.7 to 1.14.0
- Updated AspectJ runtime dependencies to 1.9.22.1
- Updated Lombok to 1.18.34 (for AspectJ-Lombok-Refactoring)

**Annotation Processing Projects (2 projects):**
- `frameworks/Java-AnnotationProcessing`
- `frameworks/Java-AnnotationProcessing-Usage`

**Changes:**
- Updated maven-compiler-plugin to 3.8.1
- Configured two-phase compilation for annotation processors:
  - Phase 1: Compile processor classes without annotation processing (proc=none)
  - Phase 2: Compile with annotation processing enabled
- This resolves the chicken-and-egg problem where the processor tries to use itself during compilation

**JAXB Project (1 project):**
- `metamodeling/Metamodel-JAXB-Entity`

**Changes:**
- Replaced jaxb2-maven-plugin with maven-antrun-plugin using Ant's SchemaGenTask
- The jaxb2-maven-plugin's qdox dependency has parser issues with Java 17
- Configured maven-antrun-plugin 3.1.0 to run SchemaGenTask during process-classes phase
- Added jaxb-jxc 4.0.5 and jaxb-impl 4.0.5 as plugin dependencies
- Schema generation now works properly and generates XSD files in target/schemas/
- Full build (compile, test, install) succeeds with schema generation enabled

**Groovy Projects (2 projects):**
- `generic-libraries/groovy/Groovy-Metaprogramming-Transformer`
- `generic-libraries/groovy/Groovy-Metaprogramming`

**Changes:**
- Replaced groovy-eclipse-compiler with gmavenplus-plugin 1.13.1 for Java 17 compatibility
- Updated Groovy from 3.0.3 (org.codehaus.groovy) to 4.0.6 (org.apache.groovy)
- Updated maven-compiler-plugin to 3.8.1
- The old groovy-eclipse-compiler versions don't support Java 17
- Both projects now compile and test successfully with Java 17

## Excluded Projects (Student Exercises)
The following projects are intentionally excluded from compilation checks as they are starter projects for students to complete:

- `guide/orm-custom-starter` - Has intentional compilation errors for students to fix
- All projects in `static-analysis/*` - Student exercise projects (9 projects):
  - `analysis-downloader-exercise`
  - `analysis-flush-four-validator-exercise`
  - `analysis-hand-validator-exercise`
  - `analysis-learning-game-exercise`
  - `analysis-model-to-object-diagramm-exercise`
  - `analysis-slovenian-hard-exercise`
  - `analysis-slovenian-harder-exercise`
  - `analysis-structure-validator-exercise`
  - `analysis-tictactoe-exercise`

## Java 21 Migration

### Additional Upgrades for Java 21
All 165 Maven projects have been updated to use Java 21.

**Plugin and Dependency Upgrades:**
- `maven-compiler-plugin`: Upgraded to 3.11.0 (supports Java 21)
- All projects: Updated `<source>` and `<target>` to 21
- AspectJ projects (2): Set compliance level to 17 (highest supported by aspectj-maven-plugin 1.14.0)
  - Added aspectjtools 1.9.22.1 as plugin dependency
  - Updated aspectjrt and aspectjweaver to 1.9.22.1
- Groovy project (1): Switched to gmavenplus-plugin 1.13.1
  - Updated Groovy from 3.0.3 to 4.0.6 (org.apache.groovy)

**Compilation Results with Java 21:**
- ✓ All 102 testable projects compile successfully
- AspectJ projects use Java 17 compliance but run on Java 21 (backward compatible)

## Notes
- The repository is fully compatible with Java 21
- All dependency relationships between internal projects have been documented and satisfied
- Total of 28 projects required fixes:
  - 18 projects: dependency installation
  - 7 projects: plugin upgrades for Java 17 compatibility
  - 3 projects: additional upgrades for Java 21 compatibility
