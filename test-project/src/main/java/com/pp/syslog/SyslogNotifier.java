package com.pp.syslog;

import org.graylog2.syslog4j.Syslog;
import org.graylog2.syslog4j.SyslogIF;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/9/4       create this file
 * </pre>
 */


public class SyslogNotifier {
    private List<String> targets;
    private int port;
    private String facility;
    private String hostname;
    private ExecutorService executor;

    public SyslogNotifier(List<String> targets, int port, String facility, String hostname) {
        this.targets = targets;
        this.port = port;
        this.facility = facility;
        this.hostname = hostname;
        this.executor = Executors.newFixedThreadPool(targets.size());
    }

    public void sendMessage(String message) {
        for (String target : targets) {
            executor.execute(new SyslogTask(target, port, facility, hostname, message));
        }
    }

    public void shutdown() {
        executor.shutdown();
    }

    private class SyslogTask implements Runnable {
        private String target;
        private int port;
        private String facility;
        private String hostname;
        private String message;

        public SyslogTask(String target, int port, String facility, String hostname, String message) {
            this.target = target;
            this.port = port;
            this.facility = facility;
            this.hostname = hostname;
            this.message = message;
        }

        public void run() {
            SyslogIF syslog = Syslog.getInstance("udp");




//            syslog.connect(target, port);
//            syslog.send(facility + hostname + message);
//            syslog.close();
        }
    }
}