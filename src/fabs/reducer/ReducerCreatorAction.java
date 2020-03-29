package fabs.reducer;

import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;

public class ReducerCreatorAction extends AbstractCreatorAction {
    @Override
    protected AbstractDialog createDialog() {
        return new ReducerDialog();
    }
}
