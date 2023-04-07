lib/HelloWorld.class: HelloWorld.java
	javac -h lib -d lib $^

HelloWorld.o: lib/HelloWorld.cpp
	JAVA_HOME=/usr/lib/jvm/java-18-openjdk LD_LIBRARY_PATH=:. g++ -c -fpic -Wall -I/usr/lib/jvm/java-18-openjdk/include/ -I/usr/lib/jvm/java-18-openjdk/include/linux lib/HelloWorld.cpp

libHelloWorld.so: HelloWorld.o
	g++ -Wl,-soname,libHelloWorld.so -shared -o libHelloWorld.so HelloWorld.o

run: lib/HelloWorld.class libHelloWorld.so
	LD_LIBRARY_PATH=$LD_LIBRARY_PATH:. java -cp lib HelloWorld
