package com.soen343.gms.model;

public enum JobState {
    Initial {
        @Override
        public JobState nextState() { return InProgress; }
        @Override
        public JobState prevState() { return this; }
        @Override
        public String getCode() { return "I"; }
    },
    InProgress {
        @Override
        public JobState nextState() { return PendingApproval; }
        @Override
        public JobState prevState() { return this; }
        public JobState onHold() { return OnHold; }
        @Override
        public String getCode() { return "IP"; }
    },
    OnHold {
        @Override
        public JobState nextState() { return InProgress; }
        @Override
        public JobState prevState() { return InProgress; }
        @Override
        public String getCode() { return "H"; }
    },
    PendingApproval {
        @Override
        public JobState nextState() { return Complete; }
        @Override
        public JobState prevState() { return InProgress; }
        @Override
        public String getCode() { return "PA"; }
    },
    Complete {
        @Override
        public JobState nextState() { return Archived; }
        @Override
        public JobState prevState() { return InProgress; }
        @Override
        public String getCode() { return "C"; }
    },
    Archived {
        @Override
        public JobState nextState() { return this; }
        @Override
        public JobState prevState() { return this; }
        @Override
        public String getCode() { return "A"; }
    };

    public abstract JobState nextState();
    public abstract JobState prevState();
    public abstract String getCode();
}
