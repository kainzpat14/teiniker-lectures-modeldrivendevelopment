mkdir -p ../java/org/se/lab/
cpp $1 templates/Main.java | grep -E -v "^#.*" > ../java/org/se/lab/Main.java
