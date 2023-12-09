package com.SocketTrench.Engine;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class EngineManager {
    private static final int FPS = 30;
    private final List<GameObject> gameObjects;
    private final EngineState engineState;
    private final EngineRenderDispatcher matchRenderDispatcher;

    public EngineManager(
        final List<GameObject> gameObjects,
        final EngineState engineState,
        final EngineRenderDispatcher matchRenderDispatcher
    ) {
        this.gameObjects = gameObjects;
        this.engineState = engineState;
        this.matchRenderDispatcher = matchRenderDispatcher;

    }

    public final void onInit() {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable task = () -> {
            this.onUpdate();
        };
        scheduler.scheduleAtFixedRate(task, 0, 1000 / FPS, TimeUnit.MILLISECONDS);
    }

    public final void onUpdate() {
        this.engineState.apply();
        for (final var gameObject : this.gameObjects) {
            EnginePhysics.apply(gameObject);
        }
        matchRenderDispatcher.dispatch("RENDER");
    }
}
