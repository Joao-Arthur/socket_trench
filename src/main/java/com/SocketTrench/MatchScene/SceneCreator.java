package com.SocketTrench.MatchScene;

import java.util.LinkedList;

import com.SocketTrench.Engine.EngineKeyAdapter;
import com.SocketTrench.Engine.EngineManager;
import com.SocketTrench.Engine.EngineRenderDispatcher;
import com.SocketTrench.Engine.EngineRenderer;
import com.SocketTrench.Engine.EngineState;
import com.SocketTrench.Engine.GameObject;
import com.SocketTrench.GUI.GUI;
import com.SocketTrench.Screens.MatchPanel;
import com.SocketTrench.Screens.MatchScreen;

public final class SceneCreator {
    public static void create() {
        final var gameObjects = new LinkedList<GameObject>();
        gameObjects.add(new BackgroundGameObject());
        gameObjects.add(new Player1GameObject());
        gameObjects.add(new Player2GameObject());

        final var engineRenderDispatcher = new EngineRenderDispatcher();
        final var engineState = new EngineState(gameObjects);
        final var engineRenderer = new EngineRenderer(gameObjects);
        final var engineManager = new EngineManager(gameObjects, engineState, engineRenderDispatcher);
        final var engineKeyAdapter = new EngineKeyAdapter(gameObjects, engineState);

        final var matchPanel = new MatchPanel(engineRenderer);
        engineRenderDispatcher.register(matchPanel);
        final var matchScreen = new MatchScreen(matchPanel, engineKeyAdapter);
        GUI.getInstance().goTo(matchScreen);
        engineManager.onInit();
    }
}
