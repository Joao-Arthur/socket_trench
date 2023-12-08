package com.SocketTrench.Match;

import java.util.LinkedList;
import java.util.List;

import com.SocketTrench.Events.Dispatcher;
import com.SocketTrench.Events.Observer;

public final class MatchKeyReleasedDispatcher implements Dispatcher<Integer> {
    public final List<Observer<Integer>> observers = new LinkedList<Observer<Integer>>();

    @Override
    public void dispatch(Integer event) {
        for (final var observer : observers)
            observer.handle(event);
    }

    @Override
    public void register(Observer<Integer> observer) {
        observers.add(observer);
    }
}
