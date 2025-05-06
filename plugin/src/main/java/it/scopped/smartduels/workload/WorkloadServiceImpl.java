package it.scopped.smartduels.workload;

import it.scopped.smartduels.SmartDuels;
import it.scopped.smartduels.SmartDuelsAPI;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayDeque;
import java.util.Deque;

public class WorkloadServiceImpl extends BukkitRunnable implements WorkloadService {

    private static final int MAX_MS_PER_TICK = 3;
    private static final int MAX_NANOS_PER_TICK = (int) (MAX_MS_PER_TICK * 1E6);
    private final Deque<WorkloadService.Workload> workloads = new ArrayDeque<>();

    @Override
    public void workload(WorkloadService.Workload workload) {
        workloads.add(workload);
    }

    @Override
    public void run() {
        long stopTime = System.nanoTime() + MAX_NANOS_PER_TICK;
        WorkloadService.Workload next;

        while (System.nanoTime() <= stopTime && (next = workloads.poll()) != null) {
            next.compute();
        }
    }

    @Override
    public void register(SmartDuelsAPI plugin) {
        runTaskTimer(plugin.bootstrap(), 0L, 1L);
    }
}
