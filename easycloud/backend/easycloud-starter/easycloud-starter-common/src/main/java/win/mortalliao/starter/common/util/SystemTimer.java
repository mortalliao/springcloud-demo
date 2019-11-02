package win.mortalliao.starter.common.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liaoyujian
 * 高效率获取系统时间
 * SystemTimer.currentTimeMillis()
 */
public class SystemTimer {
    private static class TimerTask implements Runnable {
        @Override
        public void run() {
            time = System.currentTimeMillis();
        }
    }

    private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "SystemTimer");
        thread.setDaemon(true);
        return thread;
    });

    private static final long period = Long.parseLong(System.getProperty("system.timer.period", "10"));

    private static volatile long time = System.currentTimeMillis();

    static {
        executor.scheduleAtFixedRate(new TimerTask(), period, period, TimeUnit.MILLISECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                executor.shutdown();
            }
        });
    }

    /**
     * Current time millis.
     *
     * @return the long
     */
    public static long currentTimeMillis() {
        return time;
    }
}

