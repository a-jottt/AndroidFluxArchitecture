package com.example.androidfluxarchitecture.actions;

/**
 * Created by joanna on 22.06.16.
 */
public class CallApiAction implements Action {

    private ActionTypes type;
    private DataBundle<DataKeys> bundle;

    public CallApiAction(ActionTypes type) {
        this.type = type;
        this.bundle = new DataBundle<>();
    }

    public CallApiAction(ActionTypes type, DataBundle<DataKeys> bundle) {
        this.type = type;
        this.bundle = bundle;
    }

    @Override
    public ActionType getType() {
        return type;
    }

    @Override
    public DataBundle getData() {
        return bundle;
    }
}
