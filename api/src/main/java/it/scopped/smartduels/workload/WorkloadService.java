package it.scopped.smartduels.workload;

import it.scopped.smartduels.SmartDuelsAPI;

public interface WorkloadService {

    void workload(Workload workload);

    void register(SmartDuelsAPI plugin);

    interface Workload {
        void compute();
    }
}
