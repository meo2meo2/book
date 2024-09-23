package org.momar.chapter02;

import java.io.PrintStream;

public class HelloWorldGreeter implements Greeter {
    private PrintStream printStream = System.out;

    @Override
    public void greet() {
        printStream.print("Hello World");
    }

    @Override
    public void setPrintStream(PrintStream out) {
        printStream = out;
    }
}
