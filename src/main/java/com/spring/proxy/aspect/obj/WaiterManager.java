package com.spring.proxy.aspect.obj;

import com.spring.proxy.NaiveWaiter;
import com.spring.proxy.Waiter;

public interface WaiterManager {

    public void addWaiter(Waiter waiter);

    public void addNaiveWaiter(NaiveWaiter naiveWaiter);

}
