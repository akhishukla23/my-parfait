package com.custardsource.parfait.timing;

import com.custardsource.parfait.MonitorableRegistry;


/**
 * A dummy EventTimer which implements all functionality as no-ops.
 */
public final class DummyEventTimer extends EventTimer {
    public DummyEventTimer() {
        super("dummy", new MonitorableRegistry(), ThreadMetricSuite.blank(), false, false);
    }

    private static final EventMetricCollector DUMMY_EVENT_METRIC_COLLECTOR = new EventMetricCollector(
            null) {
        public void startTiming(Timeable source, String action) {
            // no-op
        }

        public void stopTiming() {
            // no-op
        }

        public void pauseForForward() {
            // no-op
        }

        public void resumeAfterForward() {
            // no-op
        }
    };

    public EventMetricCollector getCollector() {
        return DUMMY_EVENT_METRIC_COLLECTOR;
    }

    public void registerTimeable(Timeable timeable, String eventGroup) {
        timeable.setEventTimer(this);
    }

}
