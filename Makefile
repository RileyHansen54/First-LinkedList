JAVAC = javac
JAVA = java

all: compile

compile: ItemType.java SortedLinkedList.java NodeType.java LinkedListDriver.java
	$(JAVAC) ItemType.java SortedLinkedList.java NodeType.java LinkedListDriver.jav\
a

run: compile
	$(JAVA) LinkedListDriver

clean:
	rm -rf *.class *.dSYM


