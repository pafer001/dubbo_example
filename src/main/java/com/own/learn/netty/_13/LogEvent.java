package com.own.learn.netty._13;

import java.net.InetSocketAddress;

public final class LogEvent {

    public static final byte SEPARATOR = (byte) ':';

    private InetSocketAddress source;

    private String logfile;
    private String msg;
    private long received;

    public LogEvent(String logfile, String msg) {
        this(null, logfile, msg, -1);
    }

    public LogEvent(InetSocketAddress source, String logfile,
                    String msg, long received) {
        this.source = source;
        this.logfile = logfile;
        this.msg = msg;
        this.received = received;
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getLogfile() {
        return logfile;
    }

    public String getMsg() {
        return msg;
    }

    public long getReceivedTimestamp() {
        return received;
    }
}
