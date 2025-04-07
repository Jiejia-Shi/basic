package com.example.designpattern.structural;

public class Proxy {
    public static void main(String[] args) {
        CommandExecutorProxy commandExecutorProxy = new CommandExecutorProxy(false);
        commandExecutorProxy.runCommand(" rm 123");
        commandExecutorProxy.runCommand("ls");
    }
}

interface CommandExecutor {
    public void runCommand(String cmd);
}

class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void runCommand(String cmd) {
        System.out.println("execute cmd: " + cmd);
    }
}

class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor commandExecutor;

    public CommandExecutorProxy(boolean isAdmin) {
        this.isAdmin = isAdmin;
        this.commandExecutor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) {
        // provide controlled access of a functionality
        if (!isAdmin && cmd.trim().startsWith("rm")) {
            System.out.println("rm command is not allowed for non-admin users");
            return;
        }
        commandExecutor.runCommand(cmd);
    }
}
