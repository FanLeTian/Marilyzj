package com.abc.marilyzj.adpter;

import java.util.List;

public interface BaseAdapterInterface<T> {

    void concatItems(List<T> items);

    void refreshItems(List<T> items);

}
