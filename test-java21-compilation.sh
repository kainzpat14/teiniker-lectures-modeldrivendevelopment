#!/bin/bash

MAVEN_PATH="/home/fh/devtools/apache-maven-3.9.12-bin/apache-maven-3.9.12/bin/mvn"

echo "=== JAVA 21 COMPILATION TEST ==="
echo "Java version: $(java -version 2>&1 | head -1)"
echo ""

all_poms=$(find . -name "pom.xml" -type f | sort)

passed=0
failed=0
skipped=0
failed_projects=()

for pom in $all_poms; do
    project_dir=$(dirname "$pom")
    
    # Skip Exercise projects (including -Exercise, -Excercise suffixes)
    if [[ "$project_dir" == *"/Exercise/"* ]] || [[ "$project_dir" == *"-Exercise"* ]] || [[ "$project_dir" == *"-Excercise"* ]]; then
        ((skipped++))
        continue
    fi
    
    # Skip MyName projects
    if [[ "$project_dir" == *"/MyName/"* ]] || [[ "$project_dir" == *"-MyName"* ]]; then
        ((skipped++))
        continue
    fi
    
    # Skip student starter projects
    if [[ "$project_dir" == *"/orm-custom-starter"* ]] || [[ "$project_dir" == *"/static-analysis/"* ]]; then
        ((skipped++))
        continue
    fi
    
    if $MAVEN_PATH -f "$pom" clean compile -q > /dev/null 2>&1; then
        ((passed++))
    else
        ((failed++))
        failed_projects+=("$project_dir")
    fi
done

echo "=========================================="
echo "JAVA 21 COMPILATION RESULTS"
echo "=========================================="
echo "Total Testable Projects: $((passed + failed))"
echo "Total Passed:  $passed"
echo "Total Failed:  $failed"
echo "Total Skipped: $skipped (Exercise/MyName/Student starter projects)"
echo ""

if [ $failed -gt 0 ]; then
    echo "Failed projects:"
    for proj in "${failed_projects[@]}"; do
        echo "  - $proj"
    done
    echo ""
fi

if [ $passed -eq $((passed + failed)) ]; then
    echo "✓ SUCCESS: All testable projects compile successfully with Java 21!"
else
    echo "⚠ Some projects failing - need fixes for Java 21 compatibility"
fi

