package com.example;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exercise05 {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		String cmd = args[0];
        do {
            Process process = Runtime.getRuntime().exec(new String[] {cmd});
            ProcessHandle ph = process.toHandle();
            CompletableFuture<ProcessHandle> onExit = ph.onExit();
            onExit.get();
            System.err.println("Exit value: "+process.exitValue());
        } while (true);
	}

}
