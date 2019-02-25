package com.pfuser.service;

import com.pfuser.Pojo.Flower;

import java.io.IOException;
import java.util.List;

public interface Flowerservice {
    List<Flower> show() throws IOException;
    public void update() throws IOException;
}
