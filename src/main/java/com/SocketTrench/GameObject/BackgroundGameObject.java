package com.SocketTrench.GameObject;

import java.awt.Image;

import com.SocketTrench.ImageLoader;
import com.SocketTrench.Screens.Screen;

public final class BackgroundGameObject {
    private Sprite sprite;
    private Image texture;

    public BackgroundGameObject() {
        this.sprite = new Sprite(Screen.WIDTH, Screen.HEIGHT, 0, 0);
        this.texture = ImageLoader.fromPath("background.png");
    }
}