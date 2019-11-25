package com.soen343.gms.model;

public enum JobStateEnum {
    Initial {
        @Override
        public JobStateEnum nextState() { return InProgress; }
        @Override
        public JobStateEnum prevState() { return this; }
        @Override
        public String getCode() { return "I"; }
    },
    InProgress {
        @Override
        public JobStateEnum nextState() { return PendingApproval; }
        @Override
        public JobStateEnum prevState() { return this; }
        public JobStateEnum onHold() { return OnHold; }
        @Override
        public String getCode() { return "IP"; }
    },
    OnHold {
        @Override
        public JobStateEnum nextState() { return InProgress; }
        @Override
        public JobStateEnum prevState() { return InProgress; }
        @Override
        public String getCode() { return "H"; }
    },
    PendingApproval {
        @Override
        public JobStateEnum nextState() { return Complete; }
        @Override
        public JobStateEnum prevState() { return InProgress; }
        @Override
        public String getCode() { return "PA"; }
    },
    Complete {
        @Override
        public JobStateEnum nextState() { return Archived; }
        @Override
        public JobStateEnum prevState() { return this; }
        @Override
        public String getCode() { return "C"; }
    },
    Archived {
        @Override
        public JobStateEnum nextState() { return this; }
        @Override
        public JobStateEnum prevState() { return this; }
        @Override
        public String getCode() { return "A"; }
    };

    public abstract JobStateEnum nextState();
    public abstract JobStateEnum prevState();
    public abstract String getCode();
}
