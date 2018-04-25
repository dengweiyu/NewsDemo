package demo.ifeimo.com.newsdemo.Interface;

import java.util.Objects;

/**
 * Created by Wing on 2018/3/10.
 */

public interface View {
    void showLoading();

    void hideLoading();

    void showData(Object data);

    void showFailureMessage(String msg);

    void showErrorMessage();


}
